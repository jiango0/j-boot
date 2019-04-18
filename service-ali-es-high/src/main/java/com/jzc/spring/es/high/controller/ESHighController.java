package com.jzc.spring.es.high.controller;

import com.jzc.spring.boot.common.web.ResultEntity;
import com.jzc.spring.es.high.entity.ESHighEntity;
import com.jzc.spring.es.high.service.ESHighService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "es")
public class ESHighController {

    @Autowired
    private ESHighService esHighService;

    @RequestMapping(value = "batch")
    public ResultEntity batch(@RequestBody List<ESHighEntity> list) {
        return ResultEntity.returnSuccess(esHighService.batch(list));
    }

    @RequestMapping(value = "query")
    public ResultEntity query(ESHighEntity entity) {
        return ResultEntity.returnSuccess(esHighService.query(entity));
    }

}
