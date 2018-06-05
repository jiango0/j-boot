package com.jzc.spring.basic.controller;

import com.jzc.spring.basic.entity.NoticeInfo;
import com.jzc.spring.basic.notice.event.NoticeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "notice")
public class NoticeController {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "sendMessage")
    public NoticeInfo sendMessage(@RequestBody NoticeInfo noticeInfo) {

        applicationContext.publishEvent(new NoticeEvent(this, noticeInfo));

        return noticeInfo;
    }

}
