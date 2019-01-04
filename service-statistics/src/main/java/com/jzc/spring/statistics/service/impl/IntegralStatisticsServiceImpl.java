package com.jzc.spring.statistics.service.impl;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.statistics.dao.IntegralStatisticsDao;
import com.jzc.spring.statistics.model.IntegralStatistics;
import com.jzc.spring.statistics.service.IntegralStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IntegralStatisticsServiceImpl implements IntegralStatisticsService {

    private Logger logger = LoggerFactory.getLogger(IntegralStatisticsServiceImpl.class);

    @Autowired
    IntegralStatisticsDao integralStatisticsDao;

    @Override
    public void save(IntegralStatistics statistics) {
        statistics.setId(System.currentTimeMillis());
        statistics.setCreate_time(new Date());
        statistics.setCreate_time_long(statistics.getCreate_time().getTime());
        logger.info(JSON.toJSONString(statistics) );
        integralStatisticsDao.insert(statistics);
    }

}
