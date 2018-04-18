package com.java.spring.boot.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jzc.spring.boot.Application;
import com.jzc.spring.boot.event.entity.Release;
import com.jzc.spring.boot.event.service.ReleaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ReleaseApplicationTests {

    @Autowired
    ReleaseService releaseService;

    @Test
    public void save() {
        Release release = new Release();

        release.setId(System.currentTimeMillis());
        release.setTitle("武汉真好");
        release.setContent("武汉那里好了");
        release.setCreateDate(new Date());
        release.setCreateDateLong(release.getCreateDate().getTime());
        release.setLastUpdate(new Date());
        release.setLastUpdateLong(release.getLastUpdate().getTime());

        releaseService.save(release);
    }

    @Test
    public void singleList() {

        List<Release> list = releaseService.singleList("樱花");

        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat));

    }



}
