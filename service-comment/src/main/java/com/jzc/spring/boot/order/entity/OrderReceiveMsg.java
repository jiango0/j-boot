package com.jzc.spring.boot.order.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单接收消息
 * @author Shion.W
 * @version V1.0, 2018/11/19 1:48 PM
 */
public class OrderReceiveMsg implements Serializable {
    public static enum Status {
        UNPROCESSED,
        PROCESSED;
    }

    public static enum Flag {
        UNKNOWN,
        INSERT,
        UPDATE,
        DELETE;
    }

    public static enum MsgType {
        UNKNOWN,
        ORDER;
    }

    private Long id;
    @JsonProperty("msg_id")
    private String msgId;
    @JsonProperty("msg_date")
    private Date msgDate;
    private String data;
    private Status status;
    @JsonProperty("msg_type")
    private MsgType msgType = MsgType.UNKNOWN;
    private Flag flag = Flag.UNKNOWN;

    /** 商户ID */
    private String merchant_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Date getMsgDate() {
        return msgDate;
    }

    public void setMsgDate(Date msgDate) {
        this.msgDate = msgDate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }
}
