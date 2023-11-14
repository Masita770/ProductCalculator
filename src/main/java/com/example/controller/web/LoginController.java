package com.example.controller.web;

//import com.example.config.LoginUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

//    @Autowired
//    LoginUserDetailsService service;


    @RequestMapping("/login")
    public String loginView(Model model) {
        return "login";
    }


    @GetMapping("/signIn")
    public String success(Model model) {
        return "signIn";
    }
}