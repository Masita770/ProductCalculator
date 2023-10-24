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


    @RequestMapping("/login")
    public String loginView(Model model) {
        return "login";
    }


    @RequestMapping("/signIn")
    public String success(Model model) {
        return "signIn";
    }
}