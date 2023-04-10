package com.example.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.*;

import com.example.domain.User;


@Mapper
public interface UserMapper {

    //全表示（Read処理)
    //@Select("SELECT * FROM users ")
    List<User> selectAll();

    //一件表示
    //@Select("SELECT id, username, password FROM users WHERE id = #{id}")
    Optional<User> selectOne(Long id);




    //Insert処理
    //@Insert("INSERT INTO users (id,username,password) values (#{id},#{username},#{password})")
    void add(User user);

    //Update処理
    //@Update("UPDATE users set username = #{username}, password = #{password} where id = #{id}")
    void update(User update);

    //Delete処理
    //@Delete("DELETE FROM users WHERE id = #{id}")
    void delete(User delete);
}

