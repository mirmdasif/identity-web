package com.identityweb.config.utils;

import com.identityweb.service.MailService;
import com.identityweb.utils.MailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig {

    private static final String SERVER_MAIL_ADDRESS = "galib@therapservices.net";
    private static final String SERVER_MAIL_PASSWORD = "therap2145";

    @Bean
    public String serverMailAddress(){
        return SERVER_MAIL_ADDRESS;
    }

    @Bean
    public String serverMailPassword(){
        return SERVER_MAIL_PASSWORD;
    }

    @Bean
    public MailSender mailSender(){
        return new MailSender(serverMailAddress(),serverMailPassword());
    }

    @Bean
    public MailService mailService(){
        return new MailService(mailSender());
    }
}
