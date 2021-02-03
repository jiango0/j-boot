package com.jzc.spring.boot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class A18MessageResultEntity extends MessageResultEntity {

    private Integer totalTicketNum;

    private List<A18MessageEntity> details;

}
