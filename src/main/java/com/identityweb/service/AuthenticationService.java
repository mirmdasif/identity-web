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
        String path = "/accounts/authenticate";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username",username);
        params.add("password",password);
        Object result = restServiceClient.getObjectWithQueryParameters(path, params, new UserData());
        if(result==null)
            return false;
        else {
            return true;
            //SET USER HERE AS SESSION
        }
    }

}
