package com.example.service.quantityControl;


import com.example.domain.quantityControl.Inventory;
import com.example.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;


    public List<Inventory> productGetAll() {
        return productMapper.productSelectAll();
    }

    public Optional<Inventory> productGetOne(Integer inventoryId) {
        return productMapper.productSelectOne(inventoryId);
    };
}
