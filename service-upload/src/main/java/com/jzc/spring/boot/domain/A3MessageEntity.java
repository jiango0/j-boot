package com.jzc.spring.boot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class A3MessageEntity extends MessageEntity {

    private Integer ticketNum;

    private String cardNo;

}
