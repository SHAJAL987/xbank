package com.accountservice.module.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class MainController {
    @GetMapping("/checkHealth")
    public String checkHealth(){
        return "AC Service Health is Ok!";
    }
}
