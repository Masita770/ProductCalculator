package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.ProductMapper;

@Service
public class ProductService {


    private ProductMapper mapper;

    @Autowired
    public ProductService(ProductMapper mapper) {
        this.mapper = mapper;
    }

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
//    public void stockUpdate(Stocks stocks) {
//        mapper.stocksUpdate(stocks);
//    }




    //Update処理
    public void update(Products products) {
        mapper.update(products);
    }

    //Delete処理
    public void delete(Products delete) {
        mapper.delete(delete);
    }
}

