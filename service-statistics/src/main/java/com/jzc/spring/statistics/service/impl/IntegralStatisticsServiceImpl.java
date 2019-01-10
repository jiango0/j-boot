package com.jzc.spring.statistics.service.impl;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.statistics.dao.IntegralStatisticsDao;
import com.jzc.spring.statistics.model.IntegralStatistics;
import com.jzc.spring.statistics.param.IntegralStatisticsForm;
import com.jzc.spring.statistics.service.IntegralStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public void batchSave(List<IntegralStatistics> list) {
        integralStatisticsDao.batchInsert(list);
    }

    @Override
    public List<IntegralStatistics> list(IntegralStatisticsForm form) {
        MongoTemplate mongoTemplate = integralStatisticsDao.getMongoTemplate();
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(
                        Criteria.where("create_time_long").gte(form.getStartDate().getTime()).lt(form.getEndDate().getTime())
                ),
                Aggregation.group("shop_id", "shop_name", "address")
                        .sum("num").as("num")
                        .sum("v1_num").as("v1_num")
                        .sum("v2_num").as("v2_num")
                        .sum("v3_num").as("v3_num"),
                Aggregation.project("num", "v1_num", "v2_num", "v3_num"),
                Aggregation.sort(Sort.DEFAULT_DIRECTION, "num"),
                Aggregation.skip(form.getPageIndex()),
                Aggregation.limit(form.getPageSize())
//                        .and("shop_id").previousOperation()
        );
        List<IntegralStatistics> list = mongoTemplate.aggregate(aggregation, "integralStatistics", IntegralStatistics.class).getMappedResults();
        return list;
    }

}
