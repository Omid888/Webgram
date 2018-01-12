package ir.webgram.controller;

import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.User;
import ir.webgram.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Saeed on 1/13/2018.
 */
@RestController
@RequestMapping("/api")
public class RestfulController {

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/home/post", method = RequestMethod.GET)
    protected ResponseEntity<List<Post>> home(HttpSession session,
                                              @RequestParam(name = "start", defaultValue = "0" ,required = false)Integer start,
                                              @RequestParam(name = "size", defaultValue = "10", required = false)Integer size){
        User user = (User) session.getAttribute("user");
        return new ResponseEntity<>(postService.getFeed(user, start, size), HttpStatus.OK);
    }
}
