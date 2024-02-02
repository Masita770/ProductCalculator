package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class Products {
    private Integer productId;
    private Integer pNumber;
    private String product;
    private String category;
    private String price;
    private Timestamp registrationDate;
    private Timestamp deletedDate;
//    private List<Stocks> stockList;
//    private List<Order> orders;
}
