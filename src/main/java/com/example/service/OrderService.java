package com.example.service;


import com.example.domain.Orders;
import com.example.domain.Stocks;
import com.example.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.Date;
import java.util.*;
import java.util.stream.Stream;


@Service
public class OrderService {

    @Autowired
    ProductMapper mapper;


    public void createOrder(Orders orders) {
        mapper.requestAdd(orders);
    }


    public Optional<Orders> getOrderId(Integer id) {
        return mapper.orderId(id);
    }
    public void stocksUpdate(Stocks stocks) {
        mapper.stocksUpdate(stocks);
    }
//    public void t() {
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(task, 3000);
//    }
}
