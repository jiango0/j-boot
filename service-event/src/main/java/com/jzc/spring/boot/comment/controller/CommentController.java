package com.jzc.spring.boot.comment.controller;

import com.jzc.spring.boot.comment.dao.CommentDao;
import com.jzc.spring.boot.comment.dto.CommentDto;
import com.jzc.spring.boot.comment.entity.Comment;
import com.jzc.spring.boot.common.response.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentDao commentDao;

    @GetMapping(value = "services/app/comment/hello")
    public String sayHello() {
        return "hello wourld";
    }

    @GetMapping(value = "services/app/comment/single")
    public ResultEntity<Comment> getComment(Long kid) {
        return ResultEntity.returnSuccess(commentDao.findById(kid));
    }

    @PostMapping(value = "services/app/comment/single")
    public ResultEntity<Integer> save(@RequestBody Comment comment) {
        comment.setCreateDate(new Date());
        if(comment.getId() != null) {
            Comment one = commentDao.findOne(comment.getId());
            if(one == null) {
                ResultEntity.returnSuccess(0);
            }
            one.setContent(comment.getContent());
            one.setLastUpdateDate(new Date());
            commentDao.save(one);
        } else {
            commentDao.save(comment);
        }
        return ResultEntity.returnSuccess(1);
    }

    @GetMapping(value = "services/app/comment/list")
    public ResultEntity<Page<Comment>> list(CommentDto commentDto) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(commentDto.getCurrentPage(), commentDto.getPageSize(), sort);
        return ResultEntity.returnSuccess(commentDao.findByContentIsLike("%"+commentDto.getContent()+"%", pageable));
    }

}
