package com.example.domain;


import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Orders {

    private Integer id;
    private Integer stocks_id;
    private Integer orders_number;
    private Timestamp order_date;
    private Timestamp receipt_date;
//    private List<Products> products;
}
