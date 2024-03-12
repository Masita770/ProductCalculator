package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;


    public List<Stocks> stockAll() {
        return mapper.stockAll();
    }

    public List<Products> getAll() {
        return mapper.selectAll();
    }

    //Read処理
    public Optional<Products> getListOne(Integer id) {
        return mapper.selectOne(id);
    }

//    public Optional<User> selectName(String username) {
//        return mapper.selectName(username);
//    }

    //Insert処理　3/12
    public void create(Orders products) {
//        int productId = products.getId();
//        products.setId(productId);
        mapper.add(products);
    }

    //Update処理
    public void update(Products update) {
        mapper.update(update);
    }

    //Delete処理
    public void delete(Products delete) {
        mapper.delete(delete);
    }


//    public Users certificate(Integer id) {
//        return mapper.certificate(id);
//    }
}

