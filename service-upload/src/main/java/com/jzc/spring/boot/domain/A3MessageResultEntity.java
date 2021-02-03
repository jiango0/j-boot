package com.jzc.spring.boot.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class A3MessageResultEntity extends MessageResultEntity {

    private Integer totalTicketNum;

    private List<A3MessageEntity> details;

}
