package com.customerservice.module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class MainController {
    @GetMapping("/checkHealth")
    public String checkHealth(){
        return "Customer Service Health is Ok!";
    }
}
