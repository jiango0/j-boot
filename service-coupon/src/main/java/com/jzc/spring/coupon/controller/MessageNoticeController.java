package com.jzc.spring.coupon.controller;

import com.jzc.spring.coupon.model.MessageNoticeRecord;
import com.jzc.spring.coupon.service.MessageNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageNoticeController {

    @Autowired
    MessageNoticeService messageNoticeService;

    @RequestMapping("list")
    public List<MessageNoticeRecord> list() {
        return messageNoticeService.list();
    }

    @RequestMapping("send")
    public void send(Long id) {
        messageNoticeService.send(id);
    }

}
