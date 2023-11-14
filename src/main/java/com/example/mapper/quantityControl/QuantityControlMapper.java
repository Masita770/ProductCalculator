package com.example.mapper.quantityControl;


import com.example.domain.quantityControl.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuantityControlMapper {

    List<Stock> selectStockAll();

    Optional<Stock> selectStockOne(String id);
}
