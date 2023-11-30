package com.example.service;


import com.example.domain.Users;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
//@Transactional
//public class AccountService {
//
//    @Autowired
//    UserMapper mapper;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//
//    public void register(Users usersData) {
//        usersData.setPassword(passwordEncoder.encode(usersData.getPassword()));
//        mapper.make(usersData);
//    }
//}
