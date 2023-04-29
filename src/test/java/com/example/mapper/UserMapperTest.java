package com.example.mapper;

import com.example.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@MybatisTest
class UserMapperTest {


    @Autowired
    UserMapper mapper;


    @Test
    void selectAllTest() {
        List<User> users = mapper.selectAll();
        assertEquals(5, users.size());
    }
}