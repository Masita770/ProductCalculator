package com.example.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Orders {
    private Integer id;
    private int stocksId;
    private int ordersNumber;


    private Timestamp orderDate;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date deliveryDate;
}
