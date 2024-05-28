package com.example.mapper;

import java.util.List;
import java.util.Optional;

import com.example.domain.*;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductMapper {

    //全表示（Read処理)
    //@Select("SELECT * FROM products ")
    List<Products> selectAll();

    List<Stocks> stockAll();

    //一件表示
    //@Select("SELECT id, username, password FROM users WHERE id = #{id}")
    Optional<Products> selectOne(Integer productId);



    void requestAdd(Orders orders);


    void update(Products products);


    void delete(Products delete);
}

