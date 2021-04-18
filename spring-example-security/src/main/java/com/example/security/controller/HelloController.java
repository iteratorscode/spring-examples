package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iterators
 * @date 2021.04.17
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello from security";
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi, from security";
    }
}
