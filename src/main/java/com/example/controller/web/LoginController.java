package com.example.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/list")
    private String init(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username", username);
        return "list";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}