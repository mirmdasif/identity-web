package com.identityweb.dao;

import com.identityweb.Utils.RestClient;
import com.identityweb.domain.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class UserDao {
    RestClient<User> restClient = new RestClient<User>();
    public boolean authenticateUser(String username, String password){
        String path = "/authentication";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("username",username);
        params.add("password",password);
        User user = restClient.getObject(path, params, new User());
        if(user.getUsername()!=null) {
            return true;
        }
        return false;
    }
}
