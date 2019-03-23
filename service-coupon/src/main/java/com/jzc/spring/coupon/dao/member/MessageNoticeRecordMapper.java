package com.jzc.spring.coupon.dao.member;


import com.jzc.spring.coupon.model.MessageNoticeRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageNoticeRecordMapper {

    List<MessageNoticeRecord> selectMessageNoticeRecord(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int updateMessage(MessageNoticeRecord record);

    MessageNoticeRecord detail(@Param("id") Long id);

}