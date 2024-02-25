package com.example.domain;

import lombok.*;

import com.example.domain.Stocks;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Products {
    private Integer id;
    private String pNumber;
    private String product;
    private String category;
    private String price;
    private LocalDate registrationDate;
    private Timestamp deletedDate;
    Stocks stockList;
}
