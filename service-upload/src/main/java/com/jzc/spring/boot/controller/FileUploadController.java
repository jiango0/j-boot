package com.jzc.spring.boot.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;
import com.jzc.spring.boot.domain.*;
import com.jzc.spring.boot.parse.LogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "file")
public class FileUploadController {

    @RequestMapping(value = "upload")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file,
                                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date beginDate,
                                            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate,
                                            String logTypeName,
                                            String cardNo) {
        Map<String, Object> result = new HashMap<>();
        Reader reader = null;
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<>();
        try {
            reader = new InputStreamReader(file.getInputStream());
            bufferedReader = new BufferedReader(reader);
            String row = "";
            while ((row = bufferedReader.readLine()) != null) {
                list.add(row);
            }
            List<LogEntity> logEntityList = parse(list, beginDate, endDate, logTypeName, cardNo);
            result.putAll(statistics(logEntityList));
        } catch (Exception e) {
            log.error("", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                log.error("", e);
            }
        }

        return result;
    }

    private List<LogEntity> parse(List<String> list, Date beginDate, Date endDate, String logTypeName, String cardNo) {
        List<LogEntity> logEntityList = new ArrayList<>();
        for (String row : list) {
            LogEntity logEntity = new LogEntity();
            int i = row.indexOf("-", row.indexOf(","));
            String dateStr = row.substring(0, i-5).trim();
            try {
                Date date = DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
                logEntity.setDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String[] split = row.substring(i + 1).split("[-]");

            LogTypeEnum logType = LogTypeEnum.getLogType(split[0].trim());
            if (logType == null) {
                log.error("error row：" + row);
                continue;
            }

            logEntity.setLogTypeEnum(logType);
            if (split.length > 1) {
                logEntity.setMsg(split[1].trim());
                Function<String, MessageEntity> function = logType.getFunction();
                if (function != null) {
                    logEntity.setMessageEntity(function.apply(logEntity.getMsg()));
                }
            }

            if (!StringUtils.isBlank(logTypeName) && !logTypeName.equalsIgnoreCase(logEntity.getLogTypeEnum().name())) {
                continue;
            }

            if (beginDate != null && beginDate.after(logEntity.getDate())) {
                continue;
            }

            if (endDate != null && endDate.before(logEntity.getDate())) {
                continue;
            }

            Function<MessageFilterEntity, MessageEntity> filterFunction = logType.getFilterFunction();
            if (filterFunction != null) {
                MessageFilterEntity messageFilterEntity = new MessageFilterEntity();
                messageFilterEntity.setSourceData(logEntity.getMessageEntity());
                messageFilterEntity.setCardNo(cardNo);
                MessageEntity messageEntity = filterFunction.apply(messageFilterEntity);
                if (messageEntity == null) {
                    continue;
                }
            }

            logEntityList.add(logEntity);
        }

        return logEntityList;
    }

    private Map<String, LogResultEntity> statistics(List<LogEntity> logEntityList) {
        Map<LogTypeEnum, List<MessageEntity>> logTypeEnumMap = new HashMap<>();
        for (LogEntity logEntity : logEntityList) {
            if (logTypeEnumMap.containsKey(logEntity.getLogTypeEnum())) {
                List<MessageEntity> messageEntities = logTypeEnumMap.get(logEntity.getLogTypeEnum());
                messageEntities.add(logEntity.getMessageEntity());
            } else {
                logTypeEnumMap.put(logEntity.getLogTypeEnum(), Lists.newArrayList(logEntity.getMessageEntity()));
            }
        }

        Map<String, LogResultEntity> logResultEntityMap = new HashMap<>();
        for (Map.Entry<LogTypeEnum, List<MessageEntity>> entry : logTypeEnumMap.entrySet()) {
            Function<List<MessageEntity>, MessageResultEntity> resultFunction = entry.getKey().getResultFunction();
            if (resultFunction == null) {
                continue;
            }

            LogResultEntity logResultEntity = new LogResultEntity();
            logResultEntity.setLogTypeEnum(entry.getKey());
            logResultEntity.setLogTypeName(entry.getKey().getType());
            logResultEntity.setDetail(resultFunction.apply(entry.getValue()));

            logResultEntityMap.put(entry.getKey().name(), logResultEntity);
        }

        return logResultEntityMap;
    }



}
