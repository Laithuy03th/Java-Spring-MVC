package com.example.demo.controller.client;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping("/client")
    public String getHomePage() {
        return "client/homepage/show";
    }

}
