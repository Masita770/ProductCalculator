package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<User> getListOne(Long id) {
        return mapper.selectOne(id);
    }

    //Insert処理
    public void create(User user) {
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
}

