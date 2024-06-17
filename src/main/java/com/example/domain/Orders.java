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
    private Integer id;
    private int stocksId;
    private int ordersNumber;

    private Timestamp orderDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String deliveryDate;
}
