package com.example.service;


import com.example.domain.Orders;
import com.example.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrderMapper orderMapper;

    public List<Orders> ordersList() {
        return orderMapper.ordersAll();
    }

    public void insert(Orders add) {
        orderMapper.insert(add);
    }
}
