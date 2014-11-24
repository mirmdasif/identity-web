package com.identityweb.controller;

import com.identityweb.domain.UserData;
import com.identityweb.utils.RestServiceClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by asif.hossain on 11/23/14.
 */
@Controller
public class UserVerificationController {

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    @ResponseBody()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showAdminOption() {

        RestServiceClient restServiceClient = new RestServiceClient();

        UserData userData = new UserData();
        userData.setEmail("sadasidha08@gmail.com");
        userData.setLastName("asif");
        userData.setPassword("1234");
        userData.setUsername("sadasidha");

        restServiceClient.postObject("/v1/accounts/",null, userData);
        return "1 for edit designation 2 for userData verification";
    }
}
