package com.example.mapper;

import java.util.List;
import java.util.Optional;

import com.example.domain.Products;
import com.example.domain.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    //全表示（Read処理)
    //@Select("SELECT * FROM users ")
    List<Products> selectAll();

    //一件表示
    //@Select("SELECT id, username, password FROM users WHERE id = #{id}")
    Optional<Products> selectOne(Integer id);


    //Insert処理
    //@Insert("INSERT INTO users (id,username,password) values (#{id},#{username},#{password})")
    void add(Products products);

    //Update処理
    //@Update("UPDATE users set username = #{username}, password = #{password} where id = #{id}")
    void update(Products update);

    //Delete処理
    //@Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Products delete);

//    Users certificate(Integer id);

//    void make(Products products);
}

