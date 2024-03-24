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
    private Integer productId;
    private String inventory;
    private Timestamp updateDate;
}
