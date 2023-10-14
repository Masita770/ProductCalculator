package com.example.controller.web;

import com.example.config.LoginUserDetailsService;
import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    LoginUserDetailsService service;


    @GetMapping("/login")
    public String loginView(Model model, User form) {
        return "login";
    }


    @PostMapping("/login")
    public String login(User form) {
        System.out.println(form.toString());
        return "redirect:/list";
    }


    @RequestMapping("/signIn")
    public String success(Authentication authentication, Model model) {
        return "signIn";
    }
}