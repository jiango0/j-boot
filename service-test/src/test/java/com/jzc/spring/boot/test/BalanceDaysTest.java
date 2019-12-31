package com.jzc.spring.boot.test;

import org.apache.http.client.utils.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BalanceDaysTest {

    @Test
    public void getBalanceDays () {

//        Calendar beginCalendar = Calendar.getInstance();
//
//        Calendar endCalendar = Calendar.getInstance();
//        endCalendar.set(2019, Calendar.DECEMBER, 19);
//
//        long l = beginCalendar.getTime().getTime() - endCalendar.getTime().getTime();
//
//        if (l > 0) {
//            int l1 = (int) (l / 1000 / 3600 / 24);
//        } else {
//
//        }
//
//        Math.
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//
//        System.out.println(sdf.format(endCalendar.getTime()));
//        System.out.println(sdf.format(nowCalendar.getTime()));
//
//        int days =  ((int) (endCalendar.getTime().getTime() / 1000) - (int) (nowCalendar.getTime().getTime() / 1000)) / 3600 / 24;
//
//        System.out.println(days);

    }

    @Test
    public void getBalanceDays2() {

        Date now = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.DECEMBER, 20);
        Date validEnd = calendar.getTime();

        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(now);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(validEnd);
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        long xcTime = endTime - beginTime;

        int betweenDays = (int)(xcTime / (1000 * 60 * 60 *24));//先算出两时间的毫秒数之差大于一天的天数

        if (betweenDays == 0 && xcTime > 0) {
            betweenDays = 1;
        }

        System.out.println(betweenDays > 0 ? betweenDays : 0);

    }

}
