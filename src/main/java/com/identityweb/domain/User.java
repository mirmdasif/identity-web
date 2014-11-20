package com.identityweb.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String username;
    private String mailId;

    public String getUsername() {
        return username;
    }

    public String getMailId() {
        return mailId;
    }
}
