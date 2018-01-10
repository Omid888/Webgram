package ir.webgram.controller;

import ir.webgram.model.dto.Channel;
import ir.webgram.model.entity.UserEntity;
import ir.webgram.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Saeed on 12/21/2017.
 */

@Controller
@RequestMapping("/api")
public class HomeController {


    @RequestMapping(path = "/home", method = RequestMethod.GET)
    protected ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("channel", new Channel());
        return modelAndView;
    }
}
