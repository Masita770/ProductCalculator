package com.example.domain.quantityControl;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Stock {

    private Integer id;
    private Integer inventory_id;
    private Integer account_id;
    private Integer quantity;
    private Integer time;
}
