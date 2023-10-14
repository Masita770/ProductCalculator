package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;


@AllArgsConstructor
@Getter
@Setter
public class User {

        private Integer id;
        private String username;
        private String password;

}
