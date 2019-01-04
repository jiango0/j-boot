package com.jzc.spring.statistics.dao;

import com.jzc.spring.boot.common.dao.mongo.AbstractBaseMongoDao;
import com.jzc.spring.statistics.model.IntegralStatistics;
import org.springframework.stereotype.Component;

@Component
public class IntegralStatisticsDao extends AbstractBaseMongoDao<IntegralStatistics, Long> {
}
