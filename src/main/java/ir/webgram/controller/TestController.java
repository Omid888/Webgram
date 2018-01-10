package ir.webgram.controller;

import ir.webgram.model.entity.PostEntity;
import ir.webgram.model.service.MembershipService;
import ir.webgram.model.service.PostService;
import ir.webgram.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Saeed on 12/23/2017.
 */

@RestController
@RequestMapping("/hi")
public class TestController {

    @Autowired
    private UserService service;

    @Autowired
    private PostService postService;

    @Autowired
    private MembershipService membershipService;


    @RequestMapping(value = "/user/new/{id}", method = RequestMethod.GET)
    protected String hi(@PathVariable(name = "id")Integer id){

        membershipService.findAllChannelByUserId(id);

        return "Hi :)";
    }

    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    protected String hhh(){

        return null;
    }

    @RequestMapping(value = "/post/get/{id}", method = RequestMethod.GET)
    protected List<PostEntity> dddd(@PathVariable(name = "id")Integer id){

        return null;
    }
}
