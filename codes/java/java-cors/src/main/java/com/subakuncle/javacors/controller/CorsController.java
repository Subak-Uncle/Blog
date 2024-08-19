package com.subakuncle.javacors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://example.com")
@RequestMapping("/api")
public class CorsController {

    @GetMapping("/test")
    public String example() {
        return "Hello, world!";
    }

    @CrossOrigin(origins = "http://example.com")
    @GetMapping("/example")
    public String example_2() {
        return "Hello, World!@";
    }

}
