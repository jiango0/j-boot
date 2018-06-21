package com.jzc.spring.basic.controller;

import com.jzc.spring.basic.service.RedisCasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "redis/cas")
public class RedisCasController {

    @Autowired
    RedisCasService redisCasService;

    @RequestMapping(value = "set/num")
    public void setNum(Long num) {
        redisCasService.deduction(num);
    }

}
