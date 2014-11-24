package com.identityweb.config.core;

import com.identityweb.dao.UserDao;
import com.identityweb.domain.UserData;
import com.identityweb.service.AuthenticationService;
import com.identityweb.service.UserService;
import com.identityweb.utils.RestServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class CoreConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public AuthenticationService authenticationService(){
        return  new AuthenticationService(identityRestServiceClient());
    }

    @Bean
    public UserService userService(UserDao userDao){
        return new UserService(userDao);
    }

    @Bean
    public RestServiceClient identityRestServiceClient(){
        return  new RestServiceClient();
    }
}
