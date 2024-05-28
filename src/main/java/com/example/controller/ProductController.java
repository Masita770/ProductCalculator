package com.example.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.service.ProductService;
import com.example.domain.Products;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;



    @RequestMapping("list")
    public String list(Model model) {
        List<Products> products = service.getAll();
        model.addAttribute("list", products);
        return "product/list";
    }

    // Read処理
    @GetMapping("orderManagement/{id}") //
    public String user(@PathVariable("id") Integer id, Model model) throws NotFoundException {
        Optional<Products> product = service.getListOne(id);
        product.ifPresentOrElse(inside -> model.addAttribute("product", inside), () ->
                model.addAttribute("product", product));
        return "product/orderManagement";
    }


    @GetMapping("orderEdit")
    public String requestComplete() {
        return "product/orderEdit";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id")Integer id, Model model) {
        Optional<Products> userUpdate = service.getListOne(id);
        userUpdate.ifPresentOrElse(inside -> {
            model.addAttribute("userUpdate", inside);
        }, () -> {
            System.out.println("値が存在しない");
        });
        return "product/update";
    }

    //Update処理　編集対象指定
    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id")Integer id, @ModelAttribute Products products) {
        products.setId(id);
        service.update(products);
        return "product/edit";
    }

    @RequestMapping("deletePause/{id}")
    public String deleteOne(@PathVariable("id")Integer id, @ModelAttribute Products products, Model model) {
        service.getListOne(id);
        model.addAttribute("deleteDate", products);
        return "/product/deletePause";
    }

    @GetMapping("delete/{id}")
    public String delete(@ModelAttribute Products delete) {
        service.delete(delete);
        return "product/delete";
    }
}
