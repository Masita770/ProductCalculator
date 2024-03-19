package com.example.mapper;


import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.domain.Stocks;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

//    @Select("SELECT * FROM orders" )
//    List<Orders> ordersAll();
//
////    @Select("SELECT stocks_id, product_id, inventory, update_date FROM stocks WHERE id = #{id}")
//    Optional<Stocks> orderOne(Integer stockId);
//
////    @Insert("INSERT INTO stocks(id,inventory) SELECT stocks_id,SUM (orders_number) FROM orders GROUP BY stocks_id")
//////    @Insert("INSERT INTO orders (id) VALUES (#{id})")
////    @Options(useGeneratedKeys = true, keyProperty = "id")
//    void insert(Orders add);
}
