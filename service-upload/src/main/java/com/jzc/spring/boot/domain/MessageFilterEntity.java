package com.jzc.spring.boot.domain;

import lombok.Data;

@Data
public class MessageFilterEntity {

    private MessageEntity sourceData;

    private String cardNo;

}
