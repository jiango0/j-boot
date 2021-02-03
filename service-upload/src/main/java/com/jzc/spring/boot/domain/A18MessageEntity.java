package com.jzc.spring.boot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class A18MessageEntity extends MessageEntity {

    private Integer ticketNum;

    private String cardNo;

    private String serialNumber;

}
