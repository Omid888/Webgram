package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.User;
import ir.webgram.model.service.PostService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Saeed on 12/21/2017.
 */

@Controller
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView addPost(@ModelAttribute(name = "post")Post post, HttpSession session,
                                @RequestParam(name = "channelId")Integer channelId,
                                @RequestParam(name = "channelName")String channelName){
        ModelAndView modelAndView = new ModelAndView();

        Channel channel = new Channel();
        channel.setId(channelId);
        channel.setName(channelName);

        User user = (User) session.getAttribute("user");

        post.setChannelId(channelId);
        post.setWriterId(user.getId());

        if (haveContent(post)){
            postService.save(post);
            modelAndView.setViewName("channel");
            modelAndView.addObject("posts", postService.findByChannelId(channelId, user.getId(),0, 10));
            modelAndView.addObject("channel", channel);
            modelAndView.addObject("message", "New Post Added!");
        }else {
            modelAndView.setViewName("channel");
            modelAndView.addObject("posts", postService.findByChannelId(channelId, user.getId(),0, 10));
            modelAndView.addObject("channel", channel);
            modelAndView.addObject("message", "Failed Operation!!!!");
        }

        return modelAndView;
    }

    // TODO: 1/7/2018 Jsoup connection methods impl JSOUP
    private boolean haveContent(Post post) {
        String url = post.getUrl();
        String imgUrl = "";
        String content = "";
        Document document;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            return false;
        }

        Element element = document.getElementsByTag("body").get(0);


        try {
            content = element.getElementsByTag("p").get(0).text();
        }catch (Exception e){
            post.setContent(content);
            return false;
        }

        Elements metaOgImage = document.select("meta[property=og:image]");
        if (metaOgImage!=null) {
            imgUrl = metaOgImage.attr("content");
        }


        if (content.length() > 180){
            content = content.substring(0,180) + "...";
        }

        post.setImageUrl(imgUrl);
        post.setContent(content);

        return true;
    }

    private String getImageUrl(){
        return null;
    }

    private String getUrlContent(){
        return null;
    }

}
