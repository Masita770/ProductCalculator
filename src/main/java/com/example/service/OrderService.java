package com.example.service;


import com.example.domain.Orders;
import com.example.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderService {

    @Autowired
    ProductMapper mapper;


    public void createOrder(Orders orders) {
        mapper.requestAdd(orders);
    }

}
