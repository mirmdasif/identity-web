package com.identityweb.service;

import com.identityweb.domain.User;
import com.identityweb.utils.RestServiceClient;
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
        String path = "/authenticate";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username",username);
        params.add("password",password);

        boolean isAuth = (boolean)restServiceClient.getObject(path, params, new User());
        if(isAuth)
            return true;
        return false;
    }
}
