package com.jzc.spring.boot.comment.entity;

import com.jzc.spring.boot.common.entity.GenericEntity;

import java.util.List;

public class Comment  {

    private String id;

    private Long infoId;

    private Long topId;

    private Long parentId;

    private String content;

    private Integer delFlag;

    private Integer shelveFlag;

    private String targetAuthorId;

    private String targetUserId;

    private String createUserId;

    private Long createDate;

    private String lastUpdateUserId;

    private Long lastUpdateDate;

    private List<Comment> replyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getTopId() {
        return topId;
    }

    public void setTopId(Long topId) {
        this.topId = topId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getShelveFlag() {
        return shelveFlag;
    }

    public void setShelveFlag(Integer shelveFlag) {
        this.shelveFlag = shelveFlag;
    }

    public String getTargetAuthorId() {
        return targetAuthorId;
    }

    public void setTargetAuthorId(String targetAuthorId) {
        this.targetAuthorId = targetAuthorId;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Long getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Long lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<Comment> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Comment> replyList) {
        this.replyList = replyList;
    }
}
