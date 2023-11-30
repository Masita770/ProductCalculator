package com.example.mapper;

import java.util.List;
import java.util.Optional;

import com.example.domain.Users;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    //全表示（Read処理)
    //@Select("SELECT * FROM users ")
    List<Users> selectAll();

    //一件表示
    //@Select("SELECT id, username, password FROM users WHERE id = #{id}")
    Optional<Users> selectOne(Integer id);


    //Insert処理
    //@Insert("INSERT INTO users (id,username,password) values (#{id},#{username},#{password})")
    void add(Users user);

    //Update処理
    //@Update("UPDATE users set username = #{username}, password = #{password} where id = #{id}")
    void update(Users update);

    //Delete処理
    //@Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Users delete);

    Users certificate(Integer id);

    void make(Users user);
}

