package com.jzc.spring.boot.parse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum LogTypeEnum {

    A1("获取资产成功"),
    A2("拔卡"),
    A3("机台停止出电子票"),
    A4("投电子币"),
    A5("服务器连接失败"),
    A6("机台出实体票结束"),
    A7("网络连接成功"),
    A8("收到开机广播"),
    A9("服务器连接成功"),
    A10("码表采集上传"),
    A11("日志开始上传"),
    A12("服务器连接开始"),
    A13("开始拉取配置"),
    A14("成功拉取配置"),
    A15("发送扣币流水"),
    A16("机台开始出电子票"),
    A17("读卡"),
    A18("发送退票流水"),
    A19("机台开始出实体票"),
    A20("发送解锁指令"),
    A21("获取资产开始")

    ;

    @Getter
    private String type;

    public static LogTypeEnum getLogType(String type) {
        for (LogTypeEnum logTypeEnum : values()) {
            if (logTypeEnum.getType().equalsIgnoreCase(type)) {
                return logTypeEnum;
            }
        }

        return null;
    }

}
