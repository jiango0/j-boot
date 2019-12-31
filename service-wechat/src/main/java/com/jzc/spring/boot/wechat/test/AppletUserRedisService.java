package com.jzc.spring.boot.wechat.test;


import com.jzc.spring.boot.wechat.test.domain.UserInfoDTO;
import com.jzc.spring.boot.wechat.test.utils.SecurityContext;

public interface AppletUserRedisService {

    void setSecurityContext(UserInfoDTO userInfoDTO);

    String getSecurityContext(String token);

    void setMemberCode(String memberId, String code);

    void deleteMemberCode(String memberId, String code);

    String getCode(String memberId);

    String getMemberId(String code);

    void addFormId(String memberId, String[] formIds);

    String getFormId(String memberId);

}
