package com.jzc.spring.boot.event.dao;

import com.jzc.spring.boot.event.entity.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CommentRepository extends ElasticsearchRepository<Comment, Long> {



}
