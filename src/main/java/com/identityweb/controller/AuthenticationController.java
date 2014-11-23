package com.identityweb.controller;

import com.identityweb.persistence.UserProfile;
import com.identityweb.service.MailService;
import com.identityweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthenticationController {

    private static final String MAIL_VERIFICATION_LINK = "<a href=\"http://192.168.0.72:8080/verifyEmail?cid=";
    private static final String MAIL_VERIFICATION_MESSAGE = "\">Click here to verify your email address.</a>";

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

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
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("userProfile");

        return model;

    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public void signUpPage(){
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView processSignUpRequest(UserProfile userProfile){
        int mailVerificationId = userService.saveSignUpRequest(userProfile);
        String mailVerificationMessage = MAIL_VERIFICATION_LINK + mailVerificationId + MAIL_VERIFICATION_MESSAGE;
        mailService.sendMail(userProfile.getEmail(),mailVerificationMessage);
        ModelAndView model = new ModelAndView();
        model.setViewName("signUpCompleted");
        return model;
    }

    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public void verifyEmail(@RequestParam("cid") String cid){
        userService.updateEmailVerificationStatus(cid);
        //VERIFICATION SUCCESSFUL!
    }
}


