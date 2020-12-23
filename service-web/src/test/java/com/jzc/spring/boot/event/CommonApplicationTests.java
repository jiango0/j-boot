package com.jzc.spring.boot.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jzc.spring.boot.Application;
import com.jzc.spring.boot.event.entity.Common;
import com.jzc.spring.boot.event.service.CommonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CommonApplicationTests {

    @Autowired
    CommonService commonService;

    @Test
    public void batchInfo() {
        List<Common> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "小张");
        map.put("age", 21);
        map.put("qq", "252465609");

        Common common = new Common();
        common.setId(System.currentTimeMillis());
        common.setMap(map);
        list.add(common);

        commonService.batchInfo(list);
    }

    @Test
    public void getList() {
        List<Common> list = commonService.getList(null, 21);
        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat));
    }


}
