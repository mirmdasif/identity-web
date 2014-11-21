package com.identityweb.config.core;

import com.identityweb.utils.RestServiceClient;
import com.identityweb.domain.User;
import com.identityweb.service.AuthenticationService;
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
    public RestServiceClient<User> identityRestServiceClient(){
        return  new RestServiceClient<User>();
    }
}
