package com.jzc.spring.boot.event.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "to")
public class TimeoutController {

    @RequestMapping(value = "c")
    public String toc() {
        return "1";
    }

}
