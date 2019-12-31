package com.jzc.spring.boot.wechat.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jzc.spring.boot.wechat.test.domain.UserInfoDTO;
import com.jzc.spring.boot.wechat.test.utils.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Slf4j
@RestController
public class TokenController {

    @Value(value = "classpath:member_data.json")
    private Resource resource;
    @Autowired
    AppletUserRedisService appletUserRedisService;

    @RequestMapping(value = "token")
    public void inToken() {
        List<UserInfoDTO> userInfoDTOList = getUserInfoDTOList();

        if (!CollectionUtils.isEmpty(userInfoDTOList)) {

            for (UserInfoDTO userInfoDTO : userInfoDTOList) {
                appletUserRedisService.setSecurityContext(userInfoDTO);
                log.info(userInfoDTO.getMemberId() + "," + userInfoDTO.getToken());
            }

        }

    }



    private List<UserInfoDTO> getUserInfoDTOList() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuffer message = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                message.append(line);
            }

            return JSON.parseObject(message.toString(), new TypeReference<List<UserInfoDTO>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
