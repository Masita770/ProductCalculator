package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;

    public User() {

    }


    public long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword(String password) {

        this.password = password;
    }


//    public String getMailAddress() {
//
//        return mailAddress;
//    }


//    public void setMailAddress(String mailAddress) {
//
//        this.mailAddress = mailAddress;
//    }


    public String getUsername() {

        return username;
    }


    public void setUsername(String username) {

        this.username = username;
    }
}
