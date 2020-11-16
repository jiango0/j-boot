
package com.jzc.spring.es.high.entity;


/**
 * Multimedia实体类
 * @author
 */
public class MultimediaVO {
	
	/**
	 * SKU编码
	 */
	private String skuId;

	/**
	 * 媒体类型(0图片、1视频)
	 */
	private Integer multType;
	
	/**
	 * 媒体地址
	 */
	private String multUrl;

	/**
	 * 媒体描述
	 */
	private String multDesc;

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Integer getMultType() {
		return multType;
	}

	public void setMultType(Integer multType) {
		this.multType = multType;
	}

	public String getMultUrl() {
		return multUrl;
	}

	public void setMultUrl(String multUrl) {
		this.multUrl = multUrl;
	}

	public String getMultDesc() {
		return multDesc;
	}

	public void setMultDesc(String multDesc) {
		this.multDesc = multDesc;
	}
}
