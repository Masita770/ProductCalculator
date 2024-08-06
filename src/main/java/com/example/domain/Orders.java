package com.example.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
//
public class Orders {
    private int id;
    private int stocksId;
    private int ordersNumber;

    private Timestamp orderDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String deliveryDate;

    public Orders(int id, int stocksId, int ordersNumber) {
        this.id = id;
        this.stocksId = stocksId;
        this.ordersNumber = ordersNumber;
    }
}
