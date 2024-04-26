package com.springpractice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/hello")
    public String hello()
    {
        return "hello user";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestParam String name)
    {
        return "Hi " + name  + ", Welcome back!";
    }
}
