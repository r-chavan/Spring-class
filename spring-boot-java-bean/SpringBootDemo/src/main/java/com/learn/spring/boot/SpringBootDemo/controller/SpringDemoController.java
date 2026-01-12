package com.learn.spring.boot.SpringBootDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SpringDemoController {

    @GetMapping("/springTest")
    public String testController(){
        return "Test controller initialised";
    }
}
