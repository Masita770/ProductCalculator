package com.example.domain;


import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class User {

    private Long id;
    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id.equals(user.id) && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
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
