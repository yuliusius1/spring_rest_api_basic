package com.belajarspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class welcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to Spring Boot REST API Tutorial";
    }
    

    @PostMapping
    public String other(){
        return "Welcome to Spring Boot REST API POST Tutorial";
    }
}
