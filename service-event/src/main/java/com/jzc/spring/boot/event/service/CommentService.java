package com.jzc.spring.boot.event.service;

import com.jzc.spring.boot.event.entity.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);

    List<Comment> list(String name);

}
