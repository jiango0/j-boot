package com.jzc.spring.es.high.controller;

import com.jzc.spring.es.high.entity.ESHighEntity;
import com.jzc.spring.es.high.service.ESOperationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping(value = "es/operational")
public class ESOperationalController {

    @Autowired
    private ESOperationalService esOperationalService;

    @RequestMapping(value = "insert")
    public void insert(@RequestBody ESHighEntity esHighEntity) throws IOException {
        esHighEntity.setDate(new Date());
        esOperationalService.insert(esHighEntity);
    }

    @RequestMapping(value = "update")
    public void update(@RequestBody ESHighEntity esHighEntity) throws IOException {
        esHighEntity.setDate(new Date());
        esOperationalService.update(esHighEntity);
    }

    @RequestMapping(value = "updateByQuery")
    public void updateByQuery(@RequestBody ESHighEntity esHighEntity) throws IOException {
        esHighEntity.setDate(new Date());
        esOperationalService.updateByQuery(esHighEntity);
    }

    @RequestMapping(value = "deleteByQuery")
    public void deleteByQuery(@RequestBody ESHighEntity esHighEntity) throws IOException {
        esHighEntity.setDate(new Date());
        esOperationalService.delete(esHighEntity);
    }

}
