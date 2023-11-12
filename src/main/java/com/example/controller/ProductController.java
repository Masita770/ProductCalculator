package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//public class ProductController {
//
//    @Autowired
//    UserService service;
//
//    @GetMapping("form")
//    public String newUser(@RequestBody(required = false) Model model) {
//        return "user/form";
//    }
//    @PostMapping("edit")
//    public String add(@ModelAttribute User user, BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()) {
//            return "user/edit";
//        }
//        service.create(user);
//        return "redirect:list";
//    }
//}
