package com.jzc.spring.statistics.dao;

import com.jzc.spring.boot.common.dao.mongo.AbstractBaseMongoDao;
import com.jzc.spring.statistics.model.IntegralStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class IntegralStatisticsDao extends AbstractBaseMongoDao<IntegralStatistics, Long> {

    @Autowired
    MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

}
