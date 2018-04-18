package com.java.spring.boot.event;

import com.jzc.spring.boot.Application;
import com.jzc.spring.boot.event.entity.Comment;
import com.jzc.spring.boot.event.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CommentApplicationTests {

    @Autowired
    CommentService commentService;

    @Test
    public void save() {
        Comment comment = new Comment();

        comment.setKid(System.currentTimeMillis());
        comment.setContent("评论内容");
        comment.setInfoId(1L);
        comment.setCreateDate(new Date());
        comment.setLastUpdateDate(new Date());

        commentService.save(comment);
    }

}
