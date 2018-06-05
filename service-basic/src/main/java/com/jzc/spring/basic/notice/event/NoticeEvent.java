package com.jzc.spring.basic.notice.event;

import com.jzc.spring.basic.entity.NoticeInfo;
import org.springframework.context.ApplicationEvent;

public class NoticeEvent extends ApplicationEvent {

    private NoticeInfo noticeInfo;

    public NoticeEvent(Object source, NoticeInfo noticeInfo) {
        super(source);
        this.noticeInfo = noticeInfo;
    }

    public NoticeInfo getNoticeInfo() {
        return noticeInfo;
    }

    public void setNoticeInfo(NoticeInfo noticeInfo) {
        this.noticeInfo = noticeInfo;
    }
}
