package com.example.domain;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@AllArgsConstructor
public class User {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User))
            return false;

        User user = (User) o;
        return Objects.equals(id, user.id);
    }

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
