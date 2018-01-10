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
//            postService.save(post);
            modelAndView.setViewName("showPost");
            modelAndView.addObject("post", post);
            modelAndView.addObject("channel", channel);
            modelAndView.addObject("message", "new post added!");
        }else {
            modelAndView.setViewName("showPost");
            modelAndView.addObject("post", null);
            modelAndView.addObject("channel", channel);
            modelAndView.addObject("message", "url has not any content!");
        }

        return modelAndView;
    }

    // TODO: 1/7/2018 Jsoup connection methods impl JSOUP
    private boolean haveContent(Post post) {
        String url = post.getUrl();
        String imgUrl;
        String content;
        Document document;

        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            return false;
        }

        Element elements = document.getElementsByTag("body").get(0);

//        for (Element e : elements.getAllElements()){
//            if (e.tagName().equals("header")) {
//                System.out.println("saaaaaaaaaaaaaaaaag");
//                e.remove();
//            }
//        }

        imgUrl = elements.getElementsByTag("img").get(0).attr("abs:src");
        content = elements.getElementsByTag("p").get(0).text();

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
