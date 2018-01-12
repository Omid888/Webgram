package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.User;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.UserRepository;
import ir.webgram.model.service.ChannelService;
import ir.webgram.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saeed on 12/21/2017.
 */

@Controller
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private ChannelService channelService;

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    protected ModelAndView home(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

        User user = (User) session.getAttribute("user");
        List<Post> posts = null;
        if (!user.getChannels().isEmpty()){
            posts = postService.getFeed(user);
        }
        user.setPosts(posts);
        user.setChannels(channelService.findByMemberId(user.getId()));
        modelAndView.addObject("channel", new Channel());
        return modelAndView;
    }
}
