package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUser();
        List<User> users = this.userService.getAllUserByEmailAndAddress("1@gmail.com", "hanoi");
        System.out.println(arrUsers + "and" + users);
        model.addAttribute("thuy", "test");
        return "hello";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "admin/user/create", method = RequestMethod.POST)
    public String createUserPage(@ModelAttribute("newUser") User laithithuy) {
        System.out.println("run here" + laithithuy);
        this.userService.handleSaveUser(laithithuy);

        return "hello";
    }

}
