package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {



    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
