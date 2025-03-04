package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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

    // @GetMapping("/admin/user")
    // public String getUserPage(Model model) {

    // model.addAttribute("newUser", new User());
    // return "admin/user/create";
    // }
    @GetMapping("/admin/user")
    public String getUserTable(Model model) {
        List<User> usersTable = this.userService.getAllUser();
        model.addAttribute("users1", usersTable);
        System.out.println(">>> check users: " + usersTable);

        return "admin/user/table";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserTablePage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        System.out.println("check id =  " + id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);

        return "admin/user/showUser";
    }

    @GetMapping("/admin/user/create")
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User laithithuy) {
        System.out.println("run here" + laithithuy);
        this.userService.handleSaveUser(laithithuy);

        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/update/{id}")
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

}
