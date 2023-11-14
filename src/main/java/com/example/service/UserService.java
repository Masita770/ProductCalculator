package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;


    public List<Users> getAll() {
        return mapper.selectAll();
    }

    //Read処理
    public Optional<Users> getListOne(Integer id) {
        return mapper.selectOne(id);
    }

//    public Optional<User> selectName(String username) {
//        return mapper.selectName(username);
//    }

    //Insert処理
    public void create(Users user) {
        // 6/27 追加
//        User userInfo = new User();
//        userInfo.setUsername(user.getUsername());
////        userInfo.setPassword(passwordEncoder.encode(user.getPassword()));
        mapper.add(user);
    }

    //Update処理
    public void update(Users update) {
        mapper.update(update);
    }

    //Delete処理
    public void delete(Users delete) {
        mapper.delete(delete);
    }


//    public Users certificate(Integer id) {
//        return mapper.certificate(id);
//    }
}

