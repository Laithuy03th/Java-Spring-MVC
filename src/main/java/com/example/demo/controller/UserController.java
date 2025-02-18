package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {

        String test = this.userService.handleHello();
        model.addAttribute("thuy", test);
        return "hello";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {

        String test = this.userService.handleHello();
        model.addAttribute("viet", test);
        return "admin/user/create";
    }
}

// troller
// ic class UserController {

// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("/")

// public String getHomPage() {
// return this.userService.handleHello();
// }

// }
