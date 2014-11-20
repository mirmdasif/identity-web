package com.identityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("userProfile");

        return model;

    }


    @RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
    public ModelAndView signupPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Successfully logged in!");
        model.addObject("message", "This is welcome page!");
        model.setViewName("signup");
        return model;

    }

    @RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
    public ModelAndView uploadData(@RequestParam("username")String Username, @RequestParam("file")MultipartFile file){
        ModelAndView model = new ModelAndView();
        model.setViewName("test");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        System.out.println("Hello!");
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }


}