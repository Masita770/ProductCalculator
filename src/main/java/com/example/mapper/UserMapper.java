package com.example.mapper;

import java.util.List;
import java.util.Optional;

import com.example.domain.*;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    //全表示（Read処理)
    //@Select("SELECT * FROM products ")
    List<Products> selectAll();

    List<Stocks> stockAll();

    //一件表示
    //@Select("SELECT id, username, password FROM users WHERE id = #{id}")
    Optional<Products> selectOne(Integer productId);


    //Insert処理
    //@Insert("INSERT INTO users (id,username,password) values (#{id},#{username},#{password})")
    void add(Orders products);

    //Update処理
    //@Update("UPDATE users set username = #{username}, password = #{password} where id = #{id}")
    void update(Products products);

    //Delete処理
    //@Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Products delete);

//    Optional<Products> resultOne();


    Optional<Products> resultOne(int stocksId);

    List<Products> orderAll();
}

