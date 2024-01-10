package com.example.controller.web;

//import com.example.config.LoginUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class LoginController {

//    @Autowired
//    LoginUserDetailsService service;


    @RequestMapping("/login")
    public String loginView(Model model) {
        return "security/login";
    }


    @GetMapping("/signIn")
    public String success(Model model) {
        return "security/signIn";
    }
}