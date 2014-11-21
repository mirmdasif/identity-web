package com.identityweb.service;

import com.identityweb.utils.RestServiceClient;
import com.identityweb.domain.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by galib2145 on 11/20/14.
 */
public class AuthenticationService {
    RestServiceClient<User> restServiceClient;

    public AuthenticationService(RestServiceClient<User> restServiceClient){
        this.restServiceClient = restServiceClient;
    }

    public boolean authenticateUser(String username, String password){
        String path = "/authentication";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username",username);
        params.add("password",password);


        if((username.equals("galib") && password.equals("galib")) || (username.equals("kamrul") && password.equals("kamrul"))){
            return true;
        }

        /*User user = restServiceClient.getObject(path, params, new User());
        if(user.getUsername()!=null) {
            return true;
        }*/

        return false;
    }
}
