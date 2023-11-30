package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Users {

        private Integer id;
        private String username;
        private String password;
}
