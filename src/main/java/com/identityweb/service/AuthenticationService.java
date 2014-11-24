package com.identityweb.service;

import com.identityweb.domain.UserData;
import com.identityweb.utils.RestServiceClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * Created by galib2145 on 11/20/14.
 */
public class AuthenticationService {
    RestServiceClient restServiceClient;

    public AuthenticationService(RestServiceClient restServiceClient){
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

        /*UserData user = restServiceClient.getObject(path, params, new UserData());
        if(user.getUsername()!=null) {
            return true;
        }*/

        return false;
    }
}
