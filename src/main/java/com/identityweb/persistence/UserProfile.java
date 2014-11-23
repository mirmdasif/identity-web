package com.identityweb.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="SIGN_UP_REQUESTS")
public class UserProfile implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="USER_NAME")
    private String username;

    @Column(name="EMAIL")
    private String email;

    @Column(name="CONTACT")
    private String contact;

    @Column(name="REQUEST_STATUS")
    private String requestStatus;

    @Column(name="EMAIL_VERIFICATION_STATUS")
    private String emailVerificationStatus;


    public String getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(String emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
