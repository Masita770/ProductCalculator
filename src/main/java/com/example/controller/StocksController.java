package com.example.controller;


import com.example.domain.Stocks;
import com.example.service.StocksService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class StocksController {

    @Autowired
    StocksService stocksService;

    @GetMapping("stock")
    public String stocks(Model model) {
        List<Stocks> stocks = stocksService.getAll();
        model.addAttribute("stocks", stocks);
        return "user/stock";
    }

    @GetMapping("orderForm/{id}")
    public String r(Integer id, Model model) {
        Optional<Stocks> r = stocksService.getSelect(id);
        r.ifPresentOrElse(inside -> model.addAttribute("r", inside), () ->
                model.addAttribute("r", r));
        return "user/orderForm";
    }
    @GetMapping("orderForm")
    public String t() {
        return "user/orderForm";
    }
}
