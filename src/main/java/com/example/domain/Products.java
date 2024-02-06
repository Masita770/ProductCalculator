package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class Products {
    private int id;
    private int pNumber;
    private String product;
    private String category;
    private String price;
    private Timestamp registrationDate;
    private Timestamp deletedDate;
    Stocks stockId;
    private List<Stocks> stockList;
//    private List<Order> orders;
}
