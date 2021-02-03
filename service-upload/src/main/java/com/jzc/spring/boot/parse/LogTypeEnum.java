package com.jzc.spring.boot.parse;

import com.jzc.spring.boot.domain.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;

@AllArgsConstructor
public enum LogTypeEnum {

    A1("获取资产成功", null, null, null),
    A2("拔卡", null, null, null),
    A3("机台停止出电子票", msg -> {
        A3MessageEntity messageEntity = new A3MessageEntity();

        msg = msg.trim();
        String[] msgArr = msg.split("，");
        messageEntity.setCardNo(msgArr[1].substring(7));
        messageEntity.setTicketNum(Integer.valueOf(msgArr[0].substring(5)));

        return messageEntity;
    }, list -> {
        A3MessageResultEntity a3MessageResultEntity = new A3MessageResultEntity();
        Map<String, Integer> map = new HashMap<>();
        for (MessageEntity messageEntity : list) {
            A3MessageEntity a3MessageEntity = (A3MessageEntity) messageEntity;
            if (map.containsKey(a3MessageEntity.getCardNo())) {
                Integer ticketNum = map.get(a3MessageEntity.getCardNo());
                map.put(a3MessageEntity.getCardNo(), ticketNum + a3MessageEntity.getTicketNum());
            } else {
                map.put(a3MessageEntity.getCardNo(), a3MessageEntity.getTicketNum());
            }
        }

        List<A3MessageEntity> details = new ArrayList<>();
        Integer totalTicketNum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            A3MessageEntity a3MessageEntity = new A3MessageEntity();
            a3MessageEntity.setCardNo(entry.getKey());
            a3MessageEntity.setTicketNum(entry.getValue());
            details.add(a3MessageEntity);
            totalTicketNum += a3MessageEntity.getTicketNum();
        }
        a3MessageResultEntity.setDetails(details);
        a3MessageResultEntity.setTotalTicketNum(totalTicketNum);

        return a3MessageResultEntity;
    }, messageFilterEntity -> {
        A3MessageEntity sourceData = (A3MessageEntity) messageFilterEntity.getSourceData();
        if (StringUtils.isEmpty(messageFilterEntity.getCardNo())) {
            return messageFilterEntity.getSourceData();
        }

        if (!messageFilterEntity.getCardNo().equalsIgnoreCase(sourceData.getCardNo())) {
            return null;
        }

        return messageFilterEntity.getSourceData();
    }),
    A4("投电子币", null, null, null),
    A5("服务器连接失败", null, null, null),
    A6("机台出实体票结束", null, null, null),
    A7("网络连接成功", null, null, null),
    A8("收到开机广播", null, null, null),
    A9("服务器连接成功", null, null, null),
    A10("码表采集上传", null, null, null),
    A11("日志开始上传", null, null, null),
    A12("服务器连接开始", null, null, null),
    A13("开始拉取配置", null, null, null),
    A14("成功拉取配置", null, null, null),
    A15("发送扣币流水", null, null, null),
    A16("机台开始出电子票", null, null, null),
    A17("读卡", null, null, null),
    A18("发送退票流水", msg -> {
        A18MessageEntity messageEntity = new A18MessageEntity();

        msg = msg.trim();
        String[] msgArr = msg.split("，");
        messageEntity.setTicketNum(Integer.valueOf(msgArr[2].substring(5)));
        messageEntity.setCardNo(msgArr[1].substring(3));
        messageEntity.setSerialNumber(msgArr[0].substring(6));

        return messageEntity;
    }, list -> {
        A18MessageResultEntity a18MessageResultEntity = new A18MessageResultEntity();
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (MessageEntity messageEntity : list) {
            A18MessageEntity a18MessageEntity = (A18MessageEntity) messageEntity;
            if (!set.add(a18MessageEntity.getSerialNumber())) {
                continue;
            }

            if (map.containsKey(a18MessageEntity.getCardNo())) {
                Integer ticketNum = map.get(a18MessageEntity.getCardNo());
                map.put(a18MessageEntity.getCardNo(), ticketNum + a18MessageEntity.getTicketNum());
            } else {
                map.put(a18MessageEntity.getCardNo(), a18MessageEntity.getTicketNum());
            }
        }

        List<A18MessageEntity> details = new ArrayList<>();
        Integer totalTicketNum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            A18MessageEntity a18MessageEntity = new A18MessageEntity();
            a18MessageEntity.setCardNo(entry.getKey());
            a18MessageEntity.setTicketNum(entry.getValue());
            details.add(a18MessageEntity);
            totalTicketNum += a18MessageEntity.getTicketNum();
        }
        a18MessageResultEntity.setDetails(details);
        a18MessageResultEntity.setTotalTicketNum(totalTicketNum);

        return a18MessageResultEntity;
    }, messageFilterEntity -> {
        A18MessageEntity sourceData = (A18MessageEntity) messageFilterEntity.getSourceData();
        if (StringUtils.isEmpty(messageFilterEntity.getCardNo())) {
            return messageFilterEntity.getSourceData();
        }

        if (!messageFilterEntity.getCardNo().equalsIgnoreCase(sourceData.getCardNo())) {
            return null;
        }

        return messageFilterEntity.getSourceData();
    }),
    A19("机台开始出实体票", null, null, null),
    A20("发送解锁指令", null, null, null),
    A21("获取资产开始", null, null, null)

    ;

    @Getter
    private String type;

    @Getter
    private Function<String, MessageEntity> function;

    @Getter
    private Function<List<MessageEntity>, MessageResultEntity> resultFunction;

    @Getter
    private Function<MessageFilterEntity, MessageEntity> filterFunction;

    public static LogTypeEnum getLogType(String type) {
        for (LogTypeEnum logTypeEnum : values()) {
            if (logTypeEnum.getType().equalsIgnoreCase(type)) {
                return logTypeEnum;
            }
        }

        return null;
    }

}
