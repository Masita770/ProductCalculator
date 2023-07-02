package com.example.config;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;


@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper mapper;


//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = mapper.selectName(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user not found");
        }
        // 6/28 機能について理解が足りていない
        //
        return new LoginUserDetails(user);
//        return new LoginUserDetails(Optional.of(user.get()));
//            return new LoginUserDetails(user);
//            return org.springframework.security.core.userdetails.User.withUsername(.username)
//                    .username(user.us)
//                    .password()
        }
    }
