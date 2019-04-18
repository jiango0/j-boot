package com.jzc.spring.boot.comment.dao.mongo;

import com.jzc.spring.boot.comment.entity.Comment;
import com.jzc.spring.boot.common.dao.mongo.AbstractBaseMongoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CommentMongoDao extends AbstractBaseMongoDao<Comment, Long> {

    @Autowired
    MongoTemplate mongoTemplate;

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

}
