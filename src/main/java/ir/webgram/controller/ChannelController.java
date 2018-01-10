package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.User;
import ir.webgram.model.service.ChannelService;
import ir.webgram.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Saeed on 12/21/2017.
 */

@Controller
@RequestMapping("/api")
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/channel", method = RequestMethod.POST)
    public ModelAndView newChannel(@ModelAttribute("channel")Channel channel, HttpSession session){

        User user = (User) session.getAttribute("user");
        channel.setCreator(user);

        if (channel.getName() == null || channel.getName().equals(""))
            channel.setName(user.getName()+"'s new channel");

        channelService.save(channel);

        user.addChannel(channel);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "new channel created!");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/channel/{id}", method = RequestMethod.GET)
    public ModelAndView channel(@PathVariable(name = "id")Integer id, HttpSession session,
                                @RequestParam(name = "start", defaultValue = "0" ,required = false)Integer start,
                                @RequestParam(name = "size", defaultValue = "10", required = false)Integer size){
        Channel channel = channelService.find(id);

        List<Post> posts = postService.findByChannelId(id, start, size);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("channel");
        modelAndView.addObject("posts", posts);
        modelAndView.addObject("channel", channel);
        modelAndView.addObject("post", new Post());

        return modelAndView;
    }
}
