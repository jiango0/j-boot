package com.jzc.spring.es.high.controller;

import com.jzc.spring.es.high.entity.MallProductESEntity;
import com.jzc.spring.es.high.service.ESProductTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "es/product")
public class ESProductTestController {

    @Autowired
    private ESProductTestService service;

    @RequestMapping(value = "insert")
    public void insert(@RequestBody MallProductESEntity entity) {
        service.insertProduct(entity);
    }

}
