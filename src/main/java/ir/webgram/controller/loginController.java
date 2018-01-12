package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.Login;
import ir.webgram.model.dto.User;
import ir.webgram.model.service.ChannelService;
import ir.webgram.model.service.MembershipService;
import ir.webgram.model.service.PostService;
import ir.webgram.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Saeed on 12/17/2017.
 */

@Controller
public class loginController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private ChannelService channelService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    protected String index(HttpSession session, Model model){
        if (session.getAttribute("user")==null) {
            model.addAttribute("loginUser", new Login());
            return "login";
        }
        model.addAttribute("channel", new Channel());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    protected String login(@ModelAttribute("loginUser")Login login, Model model, HttpSession session){
        if(session.getAttribute("user")!=null) {
            return "home";
        } else {
            final User user = userService.find(login);
            if (user == null) {
                model.addAttribute("message", "username or password incorrect!!");
                return "login";
            } else {
                user.setChannels(channelService.findByMemberId(user.getId()));
                user.setPosts(postService.getFeed(user));
                session.setAttribute("user", user);
                model.addAttribute("channel", new Channel());
                return "home";
            }
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected void logut(HttpSession session, Model model, HttpServletResponse response) {
        session.invalidate();
        model.asMap().clear();
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
