package com.example.controller;

//import com.example.service.AccountService;


import com.example.domain.Users;
//import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@Controller
//public class AccountController {
//
//    @Autowired
//    AccountService accountService;
//
//    @GetMapping("account")
//    public String newAccount(@RequestBody(required = false) Model model) {
//        return "account";
//    }
//    @PostMapping("createAccount")
//    public String accountAdd(@ModelAttribute Users userData, BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()) {
//            return "createAccount";
//        }
//        accountService.register(userData);
////        PasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//
//        return "user/list";
//    }
//}
