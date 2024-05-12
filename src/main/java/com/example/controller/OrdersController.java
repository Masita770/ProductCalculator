package com.example.controller;


import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.domain.Stocks;
import com.example.service.OrderService;
import com.example.service.StocksService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping("orderManagement")
    public String newProducts(@RequestBody(required = false) @ModelAttribute Products products) {
        return "product/orderManagement";
    }

    @PostMapping("orderEdit")
    public String add(@ModelAttribute Orders products, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "product/orderError";
        }
        orderService.createOrder(products);
        return "redirect:orderEdit";
    }
}
