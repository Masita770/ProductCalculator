package com.example.controller;


//import com.example.service.OrderService;


import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.domain.Stocks;
import com.example.service.OrdersService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class OrderController {

    @Autowired
    OrdersService ordersService;

//    @RequestMapping("orders")
//    public String ordersAll(Model model) {
//        model.addAttribute("o", ordersService.ordersList());
//        return "user/orders";
//    }
//
//    @GetMapping("orderForm/{id}")
//    public String r(Integer stockId, Model model) throws NotFoundException {
//        Optional<Stocks> r = ordersService.orderOne(stockId);
//        r.ifPresentOrElse(inside -> model.addAttribute("r", inside), () ->
//                model.addAttribute("r", r));
//        return "user/orderForm";
//    }
//    @GetMapping("orderForm")
//    public String t() {
//        return "user/orderForm";
//    }
//    @PostMapping("create")
//    public String orderOne(@RequestParam("product_id") Integer product_id, Model model) {
//        Optional<Stocks> stocks = ordersService.orderOne(product_id);
//        model.addAttribute("stocks", stocks);
//        return "user/orderShow";
//    }
}

//    @GetMapping("orderManagement")
//    public String newProducts(@RequestBody(required = false) Model model) {
//        return "user/orderManagement";
//    }
//    // 3/3 edit遷移がうまく行かない
//    @PostMapping("edit")
//    public String add(@ModelAttribute Orders products, BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()) {
////            int products = service.();
//            return "user/list";
//        }
//        service.create(products);
//        return "redirect:edit";
//}
