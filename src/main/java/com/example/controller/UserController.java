package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.domain.Stocks;
import org.springframework.stereotype.Controller;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.service.UserService;
import com.example.domain.Products;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

//    @Autowired
//    AccountService accountService;

    @RequestMapping("list")
    public String list(Model model) {
        List<Products> products = service.getAll();
        model.addAttribute("list", products);
        return "user/list";
    }

    //Read処理
    @GetMapping("user/{id}")
    public String user(@PathVariable("id") Integer productId, Model model) throws NotFoundException {
        Optional<Products> product = service.getListOne(productId);
        product.ifPresentOrElse(inside -> model.addAttribute("product", inside), () ->
                model.addAttribute("product", product));
        return "user/user";
    }


    @GetMapping("form")
    public String newProducts(@RequestBody(required = false) Model model) {
        return "user/form";
    }
    @PostMapping("edit")
    public String add(@ModelAttribute Products products, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "user/edit";
        }
        service.create(products);
        return "redirect:list";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id")Integer id, Model model) {
        Optional<Products> userUpdate = service.getListOne(id);
        userUpdate.ifPresentOrElse(inside -> {
            model.addAttribute("userUpdate", inside);
        }, () -> {
            System.out.println("値が存在しない");
        });
        return "user/update";
    }

    //Update処理　編集対象指定
    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id")Integer productId, @ModelAttribute Products products) {
        products.setProductId(productId);
        service.update(products);
        return "user/edit";
    }

    @RequestMapping("deletePause/{id}")
    public String deleteOne(@PathVariable("id")Integer id, @ModelAttribute Products products, Model model) {
        service.getListOne(id);
        model.addAttribute("deleteDate", products);
        return "/user/deletePause";
    }

    @GetMapping("delete/{id}")
    public String delete(@ModelAttribute Products delete) {
        service.delete(delete);
        return "user/delete";
    }
}
