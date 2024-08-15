package com.example.controller;


import com.example.domain.Orders;
import com.example.domain.Products;
import com.example.domain.Stocks;
import com.example.service.OrderService;
import com.example.service.ProductService;
import org.apache.ibatis.javassist.NotFoundException;
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


    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public OrdersController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }


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

//    @GetMapping("reception")
//    public String newTotal(@RequestBody(required = false) @ModelAttribute Orders orders) {
//        return "product/reception";
//    }


//    @GetMapping("reception/{id}")
//    public String d(@PathVariable("id")int id, Model model) {
//        Optional<Orders> f = orderService.getOrderId(id);
//        model.addAttribute("d", f);
//        return "product/reception";
//    }


    @GetMapping("recei/{id}")
    public String selectReceiveStock(@PathVariable("id") int id, Model model) throws NotFoundException {
        Optional<Products> selectProducts = productService.getListOne(id);
        selectProducts.ifPresentOrElse(inside -> {
//            int s = stocks.getInventory() + orders.getOrdersNumber();
//            stocks.setInventory(s);
            model.addAttribute("products", inside);
        }, () -> {
            System.out.println("存在しない");
        });
        return "product/recei";
    }
    @RequestMapping("/receiEdit/{id}")
    public String receivingStock(@PathVariable("id") int id, @ModelAttribute Products product) {
        product.setId(id);
        orderService.receivingStock(product);
        return "product/receiEdit";
    }
}
