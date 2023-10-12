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




//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User user)) return false;
//        return id.equals(user.id) && username.equals(user.username) && password.equals(user.password);
//    }
}
