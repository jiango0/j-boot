package com.jzc.spring.boot.test;

import org.junit.Test;
import scala.annotation.meta.param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    @Test
    public void calendarTest() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-03-22 00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0 ) {
            day_of_week = 7;
        }

        calendar.add(Calendar.DATE , -day_of_week + 1);
//        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
        System.out.print(simpleDateFormat.format(calendar.getTime()) + " 00:00:00");

//        if (LimitBuyEnum.DAY.getValue().equals(timeUnit)) {
//            startDate = calendar.getTime();
//        } else if (LimitBuyEnum.WEEK.getValue().equals(timeUnit)) {
//
//            startDate = calendar.getTime();
//        } else if (LimitBuyEnum.MONTH.getValue().equals(timeUnit)) {
//            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
//            startDate = calendar.getTime();
//        } else if (LimitBuyEnum.YEAR.getValue().equals(timeUnit)) {
//            calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_YEAR));
//            startDate = calendar.getTime();
//        }


//        param.put("startTime", simpleDateFormat.format(startDate) + " 00:00:00");
//        param.put("endTime", simpleDateFormat.format(new Date()) + " 23:59:59");

    }

}
