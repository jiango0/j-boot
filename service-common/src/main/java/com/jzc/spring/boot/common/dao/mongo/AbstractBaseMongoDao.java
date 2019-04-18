package com.jzc.spring.boot.common.dao.mongo;

import com.jzc.spring.boot.common.entity.PageList;
import com.mongodb.WriteResult;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractBaseMongoDao<T, K> implements BaseMongoDao<T, K> {

    public T findOne(Query query) {
        return getMongoTemplate().findOne(query, this.getEntityClass());
    }

    public List<T> find(Query query) {
        return getMongoTemplate().find(query, this.getEntityClass());
    }

    public void insert(T t) {
        getMongoTemplate().insert(t);
    }

    public int update(Query query, Update update) {
        WriteResult result = getMongoTemplate().upsert(query, update, this.getEntityClass());
        if(result != null) {
            return result.getN();
        }

        return 0;
    }

    public T findById(K id) {
        return getMongoTemplate().findById(id, this.getEntityClass());
    }

    public PageList<T> findPage(Integer currentPage, Integer pageSize, Query query, Sort sort) {
        long count = this.count(query);
        List<T> list = new ArrayList<>();
        if(count > 0) {
            query.skip((currentPage - 1) * pageSize).limit(pageSize);
            query.with(sort);
            list = getMongoTemplate().find(query, this.getEntityClass());
        }

        return new PageList<>(currentPage, pageSize, list, count);
    }

    public long count(Query query) {
        return getMongoTemplate().count(query, this.getEntityClass());
    }

    public void batchInsert(Collection<T> collection) {
        getMongoTemplate().insert(collection, this.getEntityClass());
    }

    public MongoTemplate getMongoTemplate() {
        return null;
    }

    public Class<T> getEntityClass() {
        return null;//(Class) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
