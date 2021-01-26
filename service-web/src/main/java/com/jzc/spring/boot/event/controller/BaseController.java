package com.jzc.spring.boot.event.controller;

import com.jzc.spring.boot.service.impl.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base")
public class BaseController {

    @Autowired
    private AbstractBaseService orderBaseService;

}
