package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.dto.Post;
import ir.webgram.model.dto.User;
import ir.webgram.model.service.FavoriteService;
import ir.webgram.model.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private FavoriteService favoriteService;

    @RequestMapping(path = "/home/post", method = RequestMethod.GET)
    protected ResponseEntity<List<Post>> home(HttpSession session,
                                              @RequestParam(name = "start", defaultValue = "0" ,required = false)Integer start,
                                              @RequestParam(name = "size", defaultValue = "10", required = false)Integer size){
        User user = (User) session.getAttribute("user");
        return new ResponseEntity<>(postService.getFeed(user, start, size), HttpStatus.OK);
    }

    @RequestMapping(value = "/channel/{id}/post", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> channel(@PathVariable(name = "id")Integer id,
                                @RequestParam(name = "start", defaultValue = "0" ,required = false)Integer start,
                                @RequestParam(name = "size", defaultValue = "10", required = false)Integer size){

        return new ResponseEntity<>(postService.findByChannelId(id, start, size), HttpStatus.OK);
    }

    @RequestMapping(value = "/post/{id}/like", method = RequestMethod.GET)
    public ResponseEntity channel(@PathVariable(name = "id")Integer id, HttpSession session){
        User user = (User) session.getAttribute("user");
        favoriteService.like(user.getId(), id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
