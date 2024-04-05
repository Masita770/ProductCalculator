package com.example.mapper;


import com.example.domain.Orders;
import com.example.domain.Products;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrderMapper {

    List<Orders> orderAll();

    List<Orders> resultOne(int stocksId);

    void addOrder(Orders orders);
}
