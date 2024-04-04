package com.example.domain;


import lombok.*;

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
    private Timestamp receiptDate;
}
