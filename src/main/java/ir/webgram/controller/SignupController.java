package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.Signup;
import ir.webgram.model.dto.User;
import ir.webgram.model.service.PostService;
import ir.webgram.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Saeed on 12/17/2017.
 */

@Controller
@RequestMapping("/api")
public class SignupController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    protected ModelAndView signup(HttpSession session){
        if(session.getAttribute("user")!=null)
            return new ModelAndView("home", "channel", new Channel());
        return new ModelAndView("signup", "signupUser", new Signup());
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    protected String signup(@ModelAttribute("signupUser") Signup signupUser, Model model, HttpSession session){

        if(session.getAttribute("user")!=null)
            return "home";

        String message = "";

        final String name = signupUser.getName();
        final String username = signupUser.getUsername();
        final String password = signupUser.getPassword();

        if ((name == null) || name.equals("") || (username == null) || username.equals(""))
            message += "\nname and username fields must be filled out! ";
        if (name.contains(" ")||password.contains(" "))
            message += "\nname and password must be without space blank! ";
        if (password.length() < 4)
            message += "\npassword length should be at least 4! ";

        if (!message.equals("")){
            model.addAttribute("message", message);
            return "signup";
        }
        if (userService.exist(username))
            message += "\nThis username is already taken! ";


        if (!message.equals("")){
            model.addAttribute("message", message);
            return "signup";
        }

        User user = userService.save(signupUser);

        user.setPosts(postService.getFeed(user));
        session.setAttribute("user", user);
        System.out.println("user id: "+user.getId());

        model.addAttribute("channel", new Channel());
        return "home";
    }
}
