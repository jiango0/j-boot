package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.event.dao.CommentRepository;
import com.jzc.spring.boot.event.entity.Comment;
import com.jzc.spring.boot.event.service.CommentService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;



    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> list(String name) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        qb.must(QueryBuilders.matchQuery("content", name));
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(qb).build();

        Page<Comment> search = commentRepository.search(searchQuery);

        return search.getContent();
    }

}