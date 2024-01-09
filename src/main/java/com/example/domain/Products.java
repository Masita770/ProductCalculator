package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@AllArgsConstructor
@Getter
@Setter
public class Products {
    private Integer id;
    private String p_number;
    private String product;
    private String category;
    private String price;
    private Timestamp registrationDate;
    private Timestamp deletedDate;
}
