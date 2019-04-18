package com.jzc.spring.boot.comment.service.impl;

import com.jzc.spring.boot.comment.dao.mongo.CommentMongoDao;
import com.jzc.spring.boot.comment.dto.CommentDTO;
import com.jzc.spring.boot.comment.entity.Comment;
import com.jzc.spring.boot.comment.service.CommentService;
import com.jzc.spring.boot.common.entity.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;

@Service
public class CommentServiceImpl implements CommentService {

    private Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentMongoDao commentMongoDao;

    @Override
    public Integer save(Comment comment) {
        if(comment.getParentId() == null && comment.getTopId() == null){
//            comment.setId(System.currentTimeMillis());
            comment.setTopId(0L);
            commentMongoDao.insert(comment);
            return 1;
        } else {
            Assert.notNull(comment.getTopId(), "父评论ID不能为空");
            Assert.notNull(comment.getParentId(), "被回复评论ID不能为空");
            //通过parentId获取父评论
            Comment searchComment = commentMongoDao.findById(comment.getParentId());
            if(searchComment == null){
                logger.error("searchComment is not =============================================");
            }
            //如果TOPID为0时，说明是父评论
            if(Long.valueOf(0).equals(searchComment.getTopId())) {
                //比较KID与TOPID是否相当
                if(!searchComment.getId().equals(comment.getTopId())) {
                    logger.error("!id equals topid =============================================");
                }
            } else {
                //如果是子评论，直接判断TOPID是否相等
                if(!searchComment.getTopId().equals(comment.getTopId())) {
                    logger.error("!topid equals topid =============================================");
                }
            }
            comment.setTargetUserId(searchComment.getCreateUserId());//目标回复用户ID
//            comment.setId(System.currentTimeMillis());

            Update update = new Update();
            update.push("replyList", comment);

            return commentMongoDao.update(Query.query(Criteria.where("id").is(searchComment.getId())), update);
        }
    }

    @Override
    public PageList<Comment> list(CommentDTO commentDTO) {
        return null;
    }

}
