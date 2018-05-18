package com.jzc.spring.boot.comment.service;

import com.jzc.spring.boot.comment.dto.CommentDTO;
import com.jzc.spring.boot.comment.entity.Comment;
import com.jzc.spring.boot.common.entity.PageList;

public interface CommentService {

    Integer save(Comment comment);

    PageList<Comment> list(CommentDTO commentDTO);

}
