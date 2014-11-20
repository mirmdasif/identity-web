package com.identityweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by galib on 11/20/14.
 */

@Controller
public class AuthVerificationController {
    @RequestMapping(value = "/verifyEmail", method = RequestMethod.GET)
    public void verifyEmail(@RequestParam("cid") String cid){
        System.out.println("The mail confirmation id : " + cid);
    }
}
