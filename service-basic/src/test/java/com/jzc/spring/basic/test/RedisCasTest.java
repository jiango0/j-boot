package com.jzc.spring.basic.test;

import com.jzc.spring.basic.service.RedisCasService;
import com.jzc.spring.boot.common.pool.ThreadPoolUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=RedisCasTest.class)
public class RedisCasTest {

    @Autowired
    RedisCasService redisCasService;

    @Test
    public void deduction() {
        final Integer[] i = {1};
        ThreadPoolUtils.execute(() -> {
            i[0]++;
            redisCasService.deduction(Long.valueOf(i[0]));
        });

    }

}
