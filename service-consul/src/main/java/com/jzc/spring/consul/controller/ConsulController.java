package com.jzc.spring.consul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "consul")
public class ConsulController {

    @RequestMapping("/")
    public String home() {
        return "hello world";
    }

}
