package com.jzc.spring.boot.event;

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

        release.setId(1524061054195L);
        release.setTitle("北京那里好");
        release.setContent("北京那里都好");
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

    @Test
    public void delete() {
        releaseService.delete(1524063516360L);
    }

//    @Test
//    public void getPage() {
//        Pageable pageable = new PageRequest(0, 5);
//        PageList<Release> list = releaseService.getPage("樱花", pageable);
//
//        System.out.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat));
//    }

    @Test
    public void detail() {
        System.out.println(JSON.toJSONString(releaseService.detail(1524063811637L), SerializerFeature.PrettyFormat));
    }



}
