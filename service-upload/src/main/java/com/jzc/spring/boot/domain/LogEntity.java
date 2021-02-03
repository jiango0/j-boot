package com.jzc.spring.boot.domain;

import com.jzc.spring.boot.parse.LogTypeEnum;
import lombok.Data;

import java.util.Date;

@Data
public class LogEntity {

    private Date date;

    private LogTypeEnum logTypeEnum;

    private String msg;

    private MessageEntity messageEntity;

}
