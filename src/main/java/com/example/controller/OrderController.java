package com.example.controller;


//import com.example.service.OrderService;


import com.example.domain.Orders;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class OrderController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("orders")
    public String ordersAll(Model model) {
        model.addAttribute("o", ordersService.ordersList());
        return "user/orders";
    }

    @GetMapping("orderManagement")
    public String newProducts(@RequestBody(required = false) Model model) {
        return "user/orderManagement";
    }
    // 3/3 edit遷移がうまく行かない
    @PostMapping("edit")
    public String add(@ModelAttribute Orders products, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
//            int products = service.();
            return "user/list";
        }
        service.create(products);
        return "redirect:edit";
}
