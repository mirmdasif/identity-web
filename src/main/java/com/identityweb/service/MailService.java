package com.identityweb.service;

import com.identityweb.utils.MailSender;

/**
 * Created by galib2145 on 11/20/14.
 */

public class MailService {
    MailSender mailSender;
    public MailService(MailSender mailSender){
        this.mailSender = mailSender;
    }

    public  void sendMail(String receiver, String mailTextMessage){
        mailSender.sendMail(receiver,mailTextMessage);
    }
}
