package com.jzc.spring.boot.order.dao;

import com.jzc.spring.boot.common.dao.mongo.AbstractBaseMongoDao;
import com.jzc.spring.boot.order.entity.SubOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class SubOrderMongoDao extends AbstractBaseMongoDao<SubOrder, Long> {

    @Autowired
    MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

}
