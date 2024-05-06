package com.example.controller;

//import com.example.service.AccountService;


//import com.example.service.AccountService;

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
