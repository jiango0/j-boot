package com.jzc.spring.boot.comment.dao;

import com.jzc.spring.boot.comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {

    Comment findById(Long id);

    Page<Comment> findByContentIsLike(String content, Pageable pageable);

}
