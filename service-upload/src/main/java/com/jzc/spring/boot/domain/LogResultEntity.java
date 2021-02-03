package com.jzc.spring.boot.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jzc.spring.boot.parse.LogTypeEnum;
import lombok.Data;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class LogResultEntity {

    private LogTypeEnum logTypeEnum;

    private String logTypeName;

    private MessageResultEntity detail;

}
