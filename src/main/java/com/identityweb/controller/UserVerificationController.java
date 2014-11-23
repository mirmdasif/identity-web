package com.identityweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by asif.hossain on 11/23/14.
 */
@Controller
public class UserVerificationController {

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    @ResponseBody()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdminOption() {

        return "1 for edit designation 2 for user verification";
    }
}
