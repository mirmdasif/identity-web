package com.identityweb.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData implements Serializable{
    private String username;
    private String mailId;
    private String email;
    private String lastName;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getMailId() {
        return mailId;
    }
}
