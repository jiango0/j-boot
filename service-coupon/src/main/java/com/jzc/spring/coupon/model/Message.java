
package com.jzc.spring.coupon.model;

import java.util.Date;
import java.util.List;

/**
 * Message实体类
 * @author
 */
public class Message {
	
	/**
	 * ID
	 */
	private String messageId;
	
	/**
	 * 商户
	 */
	private String merchantId;

	/**
	 * 0未读 1已读
	 */
	private Integer messageStatus;

	/**
	 * 消息标题
	 */
	private String title;
	
	/**
	 * 消息内容
	 */
	private String content;
	
	/**
	 * 发送人
	 */
	private String sender;
	
	/**
	 * 发送人名称
	 */
	private String senderName;
	
	/**
	 * 发送时间
	 */
	private java.util.Date createAt;
	
	/**
	 * 接收人
	 */
	private String receiver;
	
	/**
	 * 接收人名称
	 */
	private String receiverName;
	
	/**
	 * 状态改变时间
	 */
	private java.util.Date changeAt;

	private List<String> messageIdList;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getMessageStatus() {
		return messageStatus;
	}

	public void setMessageStatus(Integer messageStatus) {
		this.messageStatus = messageStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public Date getChangeAt() {
		return changeAt;
	}

	public void setChangeAt(Date changeAt) {
		this.changeAt = changeAt;
	}

	public List<String> getMessageIdList() {
		return messageIdList;
	}

	public void setMessageIdList(List<String> messageIdList) {
		this.messageIdList = messageIdList;
	}
}