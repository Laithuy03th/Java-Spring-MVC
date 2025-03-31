package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.services.UploadService;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    private final UserService userService;
    private final UploadService uploadService;

    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService,
            PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;

    }

    // @GetMapping("/")
    // public String getHomePage(Model model) {
    // List<User> arrUsers = this.userService.getAllUser();
    // List<User> users =
    // this.userService.getAllUserByEmailAndAddress("1@gmail.com", "hanoi");
    // System.out.println(arrUsers + "and" + users);
    // model.addAttribute("thuy", "test");
    // return "hello";
    // }

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

        return "admin/user/show";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserTablePage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        System.out.println("check id =  " + id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);

        return "admin/user/detail";
    }

    @GetMapping("/admin/user/create")
    public String getUserPage(Model model) {

        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") @Valid User laithithuy,
            BindingResult bindingResult, @RequestParam("laithuyFile") MultipartFile file) {

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>> check error: " + error.getField() + " - " + error.getDefaultMessage());
        }

        // validate
        if (bindingResult.hasErrors()) {
            return "admin/user/create";
        }

        //

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(laithithuy.getPassword());
        laithithuy.setAvatar(avatar);
        laithithuy.setPassword(hashPassword);
        laithithuy.setRole(this.userService.getRoleByName(laithithuy.getRole().getName()));
        this.userService.handleSaveUser(laithithuy);

        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/update/{id}")
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("admin/user/update")
    public String postUserUpdate(Model model, @ModelAttribute("newUser") User laithithuy) {
        User currentUser = this.userService.getUserById(laithithuy.getId());
        if (currentUser != null) {
            currentUser.setAddress(laithithuy.getAddress());
            currentUser.setFullName(laithithuy.getFullName());
            currentUser.setPhone(laithithuy.getPhone());
            this.userService.handleSaveUser(currentUser);

        }
        return "redirect:/admin/user";
    }

    @GetMapping("admin/user/delete/{id}")
    public String getUserDeletePage(Model model, @PathVariable long id) {

        model.addAttribute("id", id);

        // User user = new User();
        // user.setId(id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("admin/user/delete")
    public String postUserDelete(Model model, @ModelAttribute("newUser") User laithithuy) {
        this.userService.deleteUserById(laithithuy.getId());
        return "redirect:/admin/user";
    }

}
