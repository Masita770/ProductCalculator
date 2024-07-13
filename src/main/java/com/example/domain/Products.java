package com.example.domain;

import lombok.*;


import java.sql.Timestamp;
import java.time.LocalDate;


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

    // 7/10 コンストラクタを記述する
    public Products(Integer id, String pNumber, String product, String category, String price) {
        this.id = id;
        this.pNumber = pNumber;
        this.product = product;
        this.category = category;
        this.price = price;
//        this.registrationDate = registrationDate;
//        this.deletedDate = deletedDate;
    }
}
