package com.jzc.spring.statistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.jzc.spring.boot.common.web.ResultEntity;
import com.jzc.spring.statistics.model.IntegralStatistics;
import com.jzc.spring.statistics.param.IntegralStatisticsForm;
import com.jzc.spring.statistics.param.IntegralStatisticsParam;
import com.jzc.spring.statistics.service.IntegralStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping(value = "statistics")
public class IntegralStatisticsController {

    @Autowired
    IntegralStatisticsService integralStatisticsService;

    @Autowired
    RedisTemplate redisTemplate;

    @Value("classpath:json/data")
    private Resource areaRes;

    static volatile Calendar calendar = Calendar.getInstance();
    static {
        calendar.set(2017, 0, 1);
    }

    @RequestMapping(value = "save")
    public ResultEntity<Integer> save(@RequestBody IntegralStatistics statistics) {
        integralStatisticsService.save(statistics);
        return ResultEntity.returnSuccess(1);
    }

    @RequestMapping(value = "list")
    public ResultEntity<List<IntegralStatistics>> list(@RequestBody IntegralStatisticsForm form) {
        return ResultEntity.returnSuccess(integralStatisticsService.list(form));
    }

    @RequestMapping(value = "batchSave")
    public ResultEntity<Integer> batchSave() {
        List<IntegralStatistics> sendList = new ArrayList<>();
        List<IntegralStatisticsParam> list = readJson();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        Calendar c = Calendar.getInstance();
        c.setTime(calendar.getTime());
        for (int i=0; i<list.size(); i++) {
            Random rv1 = new Random();
            Random rv2 = new Random();
            Random rv3 = new Random();
            IntegralStatisticsParam param = list.get(i);
            for(int k=0; k<1000; k++) {
                int v1 = rv1.nextInt(param.getMax_v1());
                int v2 = rv2.nextInt(param.getMax_v2());
                int v3 = rv3.nextInt(param.getMax_v3());

                IntegralStatistics statistics = new IntegralStatistics();
                statistics.setId(incement());
                statistics.setShop_id(param.getShop_id() + k);
                statistics.setShop_name(param.getShop_name()  + k);
                statistics.setAddress(param.getAddress() + k);
                statistics.setV1_num(Long.valueOf(v1) );
                statistics.setV2_num(Long.valueOf(v2) );
                statistics.setV3_num(Long.valueOf(v3) );
                statistics.setNum(Long.valueOf(v1+v2+v3) );
                statistics.setCreate_time(c.getTime());
                statistics.setCreate_time_long(statistics.getCreate_time().getTime());
                sendList.add(statistics);
            }
        }

        integralStatisticsService.batchSave(sendList);
        return ResultEntity.returnSuccess(1);
    }

    private Long incement() {
        return (Long) redisTemplate.execute(new SessionCallback<Long>() {

            @Override
            public Long execute(RedisOperations redisOperations) throws DataAccessException {
                return redisOperations.opsForValue().increment("key_id", 1);
            }

        });

    }

    private List<IntegralStatisticsParam> readJson() {
        try {
            File file = areaRes.getFile();
            String jsonData = this.jsonRead(file);
            return JSONObject.parseArray(jsonData, IntegralStatisticsParam.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String jsonRead(File file){
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
    }

}
