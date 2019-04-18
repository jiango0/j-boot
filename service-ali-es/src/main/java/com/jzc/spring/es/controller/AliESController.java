package com.jzc.spring.es.controller;

import com.jzc.spring.boot.common.web.ResultEntity;
import com.jzc.spring.es.entity.AliESEntity;
import com.jzc.spring.es.entity.CustomizeInfo;
import com.jzc.spring.es.service.AliESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alies")
public class AliESController {

    @Autowired
    AliESService aliESService;

    @RequestMapping(value = "createIndex")
    public ResultEntity createIndex(String index) {
        return ResultEntity.returnSuccess(aliESService.createIndex(index));
    }

    @RequestMapping(value = "insert")
    public ResultEntity insert(@RequestBody AliESEntity aliESEntity) {
        aliESService.insert(aliESEntity);
        return ResultEntity.returnSuccess(1);
    }

    @RequestMapping(value = "query")
    public ResultEntity query(@RequestBody AliESEntity aliESEntity) {
        return ResultEntity.returnSuccess(aliESService.query(aliESEntity));
    }

    @RequestMapping(value = "list")
    public ResultEntity list(AliESEntity aliESEntity) {
        return ResultEntity.returnSuccess(aliESService.list(aliESEntity));
    }

    @RequestMapping(value = "delete")
    public ResultEntity delete(String id) {
        return ResultEntity.returnSuccess(aliESService.delete(id));
    }

    @RequestMapping(value = "customize")
    public ResultEntity customize (@RequestBody CustomizeInfo customizeInfo) {
        return ResultEntity.returnSuccess(customizeInfo);
    }

}
