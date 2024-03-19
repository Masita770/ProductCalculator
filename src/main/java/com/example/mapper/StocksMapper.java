package com.example.mapper;


import com.example.domain.Stocks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StocksMapper {


    List<Stocks> stocksAll();
//    @Select("SELECT stock_id, product_id, inventory, update_date FROM stocks WHERE stock_id = #{stock_id}")
    Optional<Stocks> stockSelect(Integer stockId);
}
