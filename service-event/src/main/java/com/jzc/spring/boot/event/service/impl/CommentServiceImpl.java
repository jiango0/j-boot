package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.event.dao.CommentRepository;
import com.jzc.spring.boot.event.entity.Comment;
import com.jzc.spring.boot.event.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> list() {
//        SearchQuery searchQuery = new NativeSearchQueryBuilder();
//        commentRepository.search(searchQuery);


        return null;
    }

}
