package com.example.controller;


import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String add(@ModelAttribute Orders orders, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "product/orderError";
        }
        orderService.createOrder(orders);
        return "redirect:orderEdit";
    }
}
