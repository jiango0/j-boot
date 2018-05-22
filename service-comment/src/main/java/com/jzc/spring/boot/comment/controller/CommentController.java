package com.jzc.spring.boot.comment.controller;

import com.jzc.spring.boot.comment.entity.Comment;
import com.jzc.spring.boot.comment.service.CommentService;
import com.jzc.spring.boot.common.web.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "save")
    public ResultEntity<Integer> save(@RequestBody Comment comment) {
        return ResultEntity.returnSuccess(commentService.save(comment));
    }

    @RequestMapping(value = "get")
    public ResultEntity<Integer> get(Integer key) {
        return ResultEntity.returnSuccess(key);
    }

}
