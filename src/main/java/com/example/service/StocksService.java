package com.example.service;


import com.example.domain.Stocks;
import com.example.mapper.StocksMapper;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StocksService {

    @Autowired
    StocksMapper mapper;

    public List<Stocks> getAll() {
        return mapper.stocksAll();
    }

    public Optional<Stocks> getSelect(Integer id) {
        return mapper.stockSelect(id);
    }
}
