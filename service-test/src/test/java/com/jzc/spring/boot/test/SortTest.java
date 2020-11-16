package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {

    class Domain {

        private Date date;

        private Integer id;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }


    @Test
    public void tette() {

        List<Domain> list = new ArrayList<Domain>(){{

            Domain domain1 = new Domain();
            domain1.setId(1);
            domain1.setDate(new Date());

            Domain domain2 = new Domain();
            domain2.setId(2);
            domain2.setDate(null);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Domain domain3 = new Domain();
            domain3.setId(3);
            domain3.setDate(new Date());

            add(domain1);
            add(domain2);
            add(domain3);
        }};

        System.out.println(JSONObject.toJSONString(list));
        List<Domain> collect = list.stream().sorted(Comparator.comparing(Domain::getDate, Comparator.nullsLast(Date::compareTo)).reversed()).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(collect));

    }


}
