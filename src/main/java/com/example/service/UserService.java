package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;


    public List<User> getAll() {
        return mapper.selectAll();
    }

    //Read処理
    public Optional<User> getListOne(Integer id) {
        return mapper.selectOne(id);
    }

//    public Optional<User> selectName(String username) {
//        return mapper.selectName(username);
//    }

    //Insert処理
    public void create(User user) {
        // 6/27 追加
//        User userInfo = new User();
//        userInfo.setUsername(user.getUsername());
////        userInfo.setPassword(passwordEncoder.encode(user.getPassword()));
        mapper.add(user);
    }

    //Update処理
    public void update(User update) {
        mapper.update(update);
    }

    //Delete処理
    public void delete(User delete) {
        mapper.delete(delete);
    }


    public User certificate(String username) {
        return mapper.certificate(username);
    }
}

