package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import toonyoo.utils.httpClient.HttpRequestResult;
import toonyoo.utils.httpClient.RestClient;

import java.util.HashMap;
import java.util.Map;

public class HttpRequestProcessorTest {

    @Test
    public void employeeApi() {

        String employeeApiUrl = "http://10.201.5.36:8080/employeeApi/base/company/info_by_shop";

        Map<String, String> para = new HashMap<String, String>();
        para.put("shop_guid", "245da5d2-3fed-44d8-91f6-58e391e67eb5");

        HttpRequestResult partnerSignResult = null;
        try {
            partnerSignResult = RestClient.getInstance()
                    .get(employeeApiUrl, false)
                    .param(para)
                    .execute(false);
        } catch (toonyoo.utils.exceptions.ServiceException e) {
            e.printStackTrace();
        }
        if(!partnerSignResult.getStatus()) {
            System.out.println("error：" + JSON.toJSONString(partnerSignResult));
        }


        System.out.println("error：" + JSON.toJSONString(partnerSignResult));
    }

}
