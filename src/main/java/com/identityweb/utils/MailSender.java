package com.identityweb.utils;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by galib on 11/20/14.
 */
public class MailSender {
    JavaMailSenderImpl sender;

    public MailSender(String username, String password){
        sender = new JavaMailSenderImpl();
        setUsernameAndPassword(username,password);
        setHostProperties();
        setMailProperties();
    }

    public void setHostProperties(){
        sender.setPort(25);
        sender.setHost("smtp.gmail.com");
    }

    public void setMailProperties(){
        sender.getJavaMailProperties().setProperty("mail.transport.protocol","smtp");
        sender.getJavaMailProperties().setProperty("mail.smtp.auth","true");
        sender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable","true");
        sender.getJavaMailProperties().setProperty("mail.debug","true");
    }

    public void setUsernameAndPassword(String username, String password){
        sender.setUsername(username);
        sender.setPassword(password);
    }

    public MimeMessage composeMail(String receiver, String mailTextMessage){
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setSubject("Therap identity verification!");
            helper.setTo(receiver);
            helper.setText(mailTextMessage,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return  message;
    }

    public  void sendMail(String receiver, String mailTextMessage){
        MimeMessage mailMessage = composeMail(receiver,mailTextMessage);
        sender.send(mailMessage);
    }
}
