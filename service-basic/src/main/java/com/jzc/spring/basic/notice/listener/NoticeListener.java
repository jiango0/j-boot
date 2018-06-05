package com.jzc.spring.basic.notice.listener;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.basic.entity.NoticeInfo;
import com.jzc.spring.basic.notice.event.NoticeEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class NoticeListener {

    @EventListener
    @Async
    public void message(NoticeEvent noticeEvent) {

        NoticeInfo noticeInfo = noticeEvent.getNoticeInfo();

        System.out.println("NoticeListener：" + JSON.toJSONString(noticeInfo));

    }

}
