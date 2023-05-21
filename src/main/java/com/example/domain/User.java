package com.example.domain;


import java.util.Objects;


public class User {


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
          if(!(o instanceof User))
              return false;
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

//    User author = (User) o;
//    return Objects.equals(id, author.id)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    private Long id;
    private String username;
    private String password;



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
