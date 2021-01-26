package com.jzc.spring.boot.controller;

import com.jzc.spring.boot.parse.LogTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "file")
public class FileUploadController {

    @RequestMapping(value = "upload")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        Reader reader = null;
        BufferedReader bufferedReader = null;
        List<String> list = new ArrayList<>();
        try {

            reader = new InputStreamReader(file.getInputStream());
            bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
//                String[] split = line.substring(25).split("[-]");
                list.add(line);
            }
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

    private void parse(Map<String, Object> result, List<String> list) {

        for (String line : list) {
            String dateStr = line.substring(0, 25);
            String[] split = line.substring(25).split("[-]");
            String type = split[0];
            LogTypeEnum logType = LogTypeEnum.getLogType(type);
            if (logType == null) {
                log.error(line);
                continue;
            }
            if (logType.equals(LogTypeEnum.A3)) {

            } else if (logType.equals(LogTypeEnum.A18)) {

            }


        }

    }



}
