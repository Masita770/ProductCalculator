package com.example.controller.web;

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


    @GetMapping("/login")
    public String loginView(Model model) {
        return "login";
    }

    @PostMapping
    String loginView() {

        return "redirect:/list";
    }

    @RequestMapping("/login")
    public String error(Model model) {
        model.addAttribute("errorMsg", "ログイン認証に失敗");
        return "login";
    }


    @GetMapping("/success")
    public String success() {
        return "success";
    }

}