package com.jzc.spring.boot.event.dao;

import com.jzc.spring.boot.event.entity.Comment;
import com.jzc.spring.boot.event.entity.Common;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Map;

public interface CommonRepository extends ElasticsearchRepository<Common, Long> {
}
