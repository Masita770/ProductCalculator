package com.example.controller;


import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.domain.Stocks;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//
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

    @GetMapping("reception")
    public String newTotal(@RequestBody(required = false) @ModelAttribute Orders orders) {
        return "product/reception";
    }

    @PostMapping("reception")
    public String total(@PathVariable("id") int orderId, @ModelAttribute Orders date, @ModelAttribute Stocks stocks, Model model) {
        // 製品を指定
        Optional<Orders> i = orderService.getOrderId(orderId);
        date.setId(orderId);
        orderService.stocksUpdate(stocks);
        // 発注データ 在庫データ 合計
        int sumF = Integer.parseInt(i.get().getDeliveryDate() + stocks.getInventory());
        // 上で合計したものを
        i.get().setDeliveryDate(date.getDeliveryDate());
        // 上で合計したものを在庫に格納
        stocks.setInventory(sumF);
//        date.setDeliveryDate(stocks.getInventory());
//        model.addAttribute("t", t);
//        model.addAttribute("o", "条件2");
        return "redirect:product/reception";
    }
}
