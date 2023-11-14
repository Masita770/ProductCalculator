package com.example.service.quantityControl;


import com.example.domain.quantityControl.Stock;
import com.example.mapper.quantityControl.QuantityControlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuantityControlService {

    @Autowired
    QuantityControlMapper mapper;


    public List<Stock> getAll() {
        return mapper.selectStockAll();
    }

    public Optional<Stock> getOne(String id) {
        return mapper.selectStockOne(id);
    }
}
