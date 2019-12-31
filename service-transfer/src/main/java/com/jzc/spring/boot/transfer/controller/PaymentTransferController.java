package com.jzc.spring.boot.transfer.controller;

import com.jzc.spring.boot.transfer.service.PaymentTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
@RequestMapping(value = "transfer")
public class PaymentTransferController {

    @Autowired
    PaymentTransferService paymentTransferService;

    @RequestMapping(value = "charges")
    public String chargesTransfer(String startDate, String endDate, String shopId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar startDateCalendar = Calendar.getInstance();
        startDateCalendar.setTime(sdf.parse(startDate));
        startDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startDateCalendar.set(Calendar.MINUTE, 0);
        startDateCalendar.set(Calendar.SECOND, 0);
        startDateCalendar.set(Calendar.MILLISECOND, 0);

        Calendar endDateCalendar = Calendar.getInstance();
        if (!StringUtils.isEmpty(endDate)) {
            endDateCalendar.setTime(sdf.parse(endDate));
        }
        endDateCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endDateCalendar.set(Calendar.MINUTE, 59);
        endDateCalendar.set(Calendar.SECOND, 59);
        endDateCalendar.set(Calendar.MILLISECOND, 0);

        paymentTransferService.chargesTransfer(startDateCalendar.getTime(), endDateCalendar.getTime(), shopId);
        return "success";
    }

    @RequestMapping(value = "refund")
    public String refundTransfer(String startDate, String endDate, String shopId) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar startDateCalendar = Calendar.getInstance();
        startDateCalendar.setTime(sdf.parse(startDate));
        startDateCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startDateCalendar.set(Calendar.MINUTE, 0);
        startDateCalendar.set(Calendar.SECOND, 0);
        startDateCalendar.set(Calendar.MILLISECOND, 0);

        Calendar endDateCalendar = Calendar.getInstance();
        if (!StringUtils.isEmpty(endDate)) {
            endDateCalendar.setTime(sdf.parse(endDate));
        }
        endDateCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endDateCalendar.set(Calendar.MINUTE, 59);
        endDateCalendar.set(Calendar.SECOND, 59);
        endDateCalendar.set(Calendar.MILLISECOND, 0);

        paymentTransferService.refundTransfer(startDateCalendar.getTime(), endDateCalendar.getTime(), shopId);
        return "success";
    }

}
