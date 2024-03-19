package com.example.domain;


import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stocks {
    private Integer id;
    private Integer product_id;
    private String inventory;
    private Timestamp update_date;
}
