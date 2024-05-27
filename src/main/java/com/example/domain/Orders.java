package com.example.domain;


import com.example.Form.DeliveryDate;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

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
//    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private DeliveryDate deliveryDate;
}
