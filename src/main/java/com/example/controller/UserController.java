package com.example.controller;

import java.util.List;
import java.util.Optional;

//import com.example.service.AccountService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.domain.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

//    @Autowired
//    AccountService accountService;

    @RequestMapping("list")
    public String list(Model model) {
        List<User> users = service.getAll();
        model.addAttribute("list", users);
        return "user/list";
    }

    //Read処理
    @GetMapping("user/{id}")
    public String user(@PathVariable("id") Integer id, Model model) throws NotFoundException {
        Optional<User> user = service.getListOne(id);
        user.ifPresentOrElse(inside -> model.addAttribute("user", inside), () ->
                model.addAttribute("user", user));
        return "user/user";
    }


    @GetMapping("form")
    public String newUser(@RequestBody(required = false) Model model) {
        return "user/form";
    }
    @PostMapping("edit")
    public String add(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "user/edit";
        }
        service.create(user);
        return "redirect:list";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id")Integer id, Model model) {
        Optional<User> userUpdate = service.getListOne(id);
        userUpdate.ifPresentOrElse(inside -> {
            model.addAttribute("userUpdate", inside);
        }, () -> {
            System.out.println("値が存在しない");
        });
        return "user/update";
    }

    //Update処理　編集対象指定
    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id")Integer id, @ModelAttribute User user) {
        user.setId(id);
        service.update(user);
        return "user/edit";
    }

    @RequestMapping("deletePause/{id}")
    public String deleteOne(@PathVariable("id")Integer id, @ModelAttribute User user, Model model) {
        service.getListOne(id);
        model.addAttribute("deleteDate", user);
        return "/user/deletePause";
    }

    @GetMapping("delete/{id}")
    public String delete(@ModelAttribute User delete) {
        service.delete(delete);
        return "user/delete";
    }
}
