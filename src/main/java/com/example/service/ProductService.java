package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.ProductMapper;

@Service
public class ProductService {

    @Autowired
    ProductMapper mapper;


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




    //Update処理
    public void update(Products products) {
        mapper.update(products);
    }

    //Delete処理
    public void delete(Products delete) {
        mapper.delete(delete);
    }
}

