package com.example.service;


import com.example.domain.Orders;
import com.example.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


@Service
public class OrderService {

    @Autowired
    ProductMapper mapper;


    public void createOrder(Orders orders) {
        mapper.requestAdd(orders);
    }

    Scanner scanner = new Scanner(System.in);
    String inputWords = scanner.next();

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
