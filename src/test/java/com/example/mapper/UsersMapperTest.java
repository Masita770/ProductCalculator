package com.example.mapper;

import com.example.domain.Products;
import com.example.service.ProductService;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@DBRider
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Mapper
@MybatisTest
class UsersMapperTest {

    @InjectMocks
    ProductService service;

//    @Mock
    @Autowired
ProductMapper mapper;
//    List testUsers = List.of(
//            new User(1L, "yamashita", "3344"));
//    User user = new User(1L, "takahashi", "334532");


    @Test
    @DataSet(value = "datasets/tests.yml")
    @Transactional
    void selectAllTest() {
        List<Products> tests = mapper.selectAll();
        org.assertj.core.api.Assertions.assertThat(tests).containsExactly(
                new Products(1, "yamashita", "3333"),
                new Products(2, "nakabayashi", "2222"),
                new Products(3, "tsukamoto", "4444")
        );
    }


    @Test
    @DataSet(value = "datasets/tests.yml", cleanAfter = true)
    @Transactional
    void insertTest() {
        Products newUsers = new Products(1, "yamashita", "33453");
        mapper.add(newProducts);
       System.out.println(newUsers);
    }

    @Test
    @DataSet(value = "datasets/tests.yml", cleanAfter = true)
    @Transactional
    void selectOneTest() throws Exception {
//        Mockito.doReturn(Optional.of(user)).when(mapper).selectOne(1L);
        Optional<Users> testUser1 = mapper.selectOne(1);

//        //Optional<User> user = mapper.selectOne(1L);
        Assertions.assertThat(testUser1).isEqualTo(
                Optional.of(new Users(1, "takahashi", "334532")));
    }

    @Test
    @DataSet(value = "datasets/tests.yml", cleanAfter = true)
    @Transactional
    void updateTest() throws Exception {
        Users usersUpdate = new Users(1, "yamazaki", "44424");
        mapper.update(usersUpdate);
        System.out.println(usersUpdate);
    }

    @Test
    @DataSet(value = "datasets/test.yml", cleanAfter = true)
    @Transactional
    void deleteTest() {
        Users deleteUsers = new Users(1, "yamazaki", "333243");
        mapper.delete(deleteUsers);
    }
}