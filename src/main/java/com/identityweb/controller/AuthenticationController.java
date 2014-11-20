package com.identityweb.controller;

import com.identityweb.Utils.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthenticationController {

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



    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public ModelAndView userProfilePage() {
        System.out.println("Sending mail!");
        MailSender mailSender = new MailSender("galib@therapservices.net","therap2145");

        mailSender.sendMail("galib2145@gmail.com","<a href=\"http://localhost:8080/verifyEmail?cid=0123\">Click here!!</a>");
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("userProfile");

        return model;

    }
}
