package com.jzc.spring.statistics.controller;

import com.jzc.spring.boot.common.web.ResultEntity;
import com.jzc.spring.statistics.model.IntegralStatistics;
import com.jzc.spring.statistics.service.IntegralStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "statistics")
public class IntegralStatisticsController {

    @Autowired
    IntegralStatisticsService integralStatisticsService;

    @RequestMapping(value = "save")
    public ResultEntity<Integer> save(@RequestBody IntegralStatistics statistics) {
        integralStatisticsService.save(statistics);
        return ResultEntity.returnSuccess(1);
    }

}
