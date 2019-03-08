package com.jzc.spring.coupon.controller;

import com.jzc.spring.coupon.constant.PartnerMap;
import com.jzc.spring.coupon.model.CouponExcel;
import com.jzc.spring.coupon.service.CouponService;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("coupon")
public class CouponController {

    private Logger logger = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    CouponService couponService;

    @RequestMapping(value = "/selectCustomerCoupon")
    public List<CouponExcel> selectCustomerCoupon(String startString, String endString, String partner_id) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse(startString);
        Date end = sdf.parse(endString);
        int days = this.diffDays(start, end);
        //获取数据
        List<List<CouponExcel>> couponExcel = this.getCouponExcel(start, days, partner_id);

        Integer month = null;
        int startIndex = 0;
        for(int i=0; i<couponExcel.size(); i++) {
            List<CouponExcel> couponExcelList = couponExcel.get(i);
            if(!CollectionUtils.isEmpty(couponExcelList)) {
                CouponExcel couponExcel1 = couponExcelList.get(0);
                Date first = couponExcel1.getDate_activation();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(first);
                int currentMonth = calendar.get(Calendar.MONTH);
                if(month == null) {
                    month = currentMonth;
                    continue;
                }
                if(month != currentMonth ) {
                    logger.info("month ->" + month);
                    this.exportExcel(couponExcel.subList(startIndex, i), month, partner_id);
                    startIndex = i;
                    month = currentMonth;
                }
                logger.info("i = " + i + " size " + couponExcel.size());
            }
            if((i+1) == couponExcel.size() ) {
                if(month == null) {
                    month = 0;
                }
                logger.info("last month ->" + month);
                this.exportExcel(couponExcel.subList(startIndex, i+1), month, partner_id);
            }
        }



//        List<CouponExcel> list = new ArrayList<>();
//        Date first = null;
//        for(List<CouponExcel> couponExcelList : couponExcel) {
//            if(!CollectionUtils.isEmpty(couponExcelList)) {
//                CouponExcel couponExcel1 = couponExcelList.get(0);
//                if(first == null) {
//                    list.addAll(couponExcelList);
//                    first = couponExcel1.getDate_activation();
//                    continue;
//                }
//
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(first);
//                int firstMonth = calendar.get(Calendar.MONTH);
//
//                calendar.setTime(couponExcel1.getDate_activation());
//                int currentMonth = calendar.get(Calendar.MONTH);
//                first = couponExcel1.getDate_activation();
//                if(firstMonth == currentMonth) {
//                    list.addAll(couponExcelList);
//                } else {
//                    this.exportExcel(list, firstMonth);
//                    list = new ArrayList<>();
//                    list.addAll(couponExcelList);
//                    first = couponExcel1.getDate_activation();
//                }
//            }
//        }

        return null;
    }

    private List<List<CouponExcel>> getCouponExcel(Date start, int days, String partner_id) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        List<List<CouponExcel>> list = new ArrayList<>();
        for(int i=0; i<days; i++) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date startDate = calendar.getTime();

            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            Date endDate = calendar.getTime();

            list.add(couponService.selectCustomerCoupon(startDate, endDate, partner_id));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return list;
    }

    private void exportExcel(List<List<CouponExcel>> couponExcel, int month, String partner_id) {
        FileInputStream fs = null;
        FileOutputStream out = null;
        String fileName = "";
        try {
            fileName = "D:\\data_excel\\coupon\\"+ PartnerMap.getPartnerName(partner_id) + (month+1) + "月.xlsx";
            File file = new File(fileName);
            if(!file.exists()) {
                file.createNewFile();
            }

//            fs = new FileInputStream(file);
            SXSSFWorkbook workbook = new SXSSFWorkbook();
            out = new FileOutputStream(file);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SXSSFSheet sheetAt = null;
            int h = 0;
            for(int i=0; i<couponExcel.size(); i++) {
                if(i == 0 || i == 11 || i == 21) {
                    sheetAt = workbook.createSheet(this.sheetName(i));
                    h = 0;
                    SXSSFRow row = sheetAt.createRow(h);
                    row.createCell(0).setCellValue("顾客名称");
                    row.createCell(1).setCellValue("customer_id");
                    row.createCell(2).setCellValue("优惠券名称");
                    row.createCell(3).setCellValue("启用金额");
                    row.createCell(4).setCellValue("购买商品名称");
                    row.createCell(5).setCellValue("最终支付金额");
                    row.createCell(6).setCellValue("绑定日期");
                    row.createCell(7).setCellValue("核销日期");
                    row.createCell(8).setCellValue("shop_guid");
                    row.createCell(9).setCellValue("优惠券状态");
                    h++;
                }
                List<CouponExcel> couponExcelList = couponExcel.get(i);
                for(CouponExcel couponExcel1 : couponExcelList) {
                    SXSSFRow row = sheetAt.createRow(h);

                    row.createCell(0).setCellValue(couponExcel1.getCustomerName() == null ? "" : couponExcel1.getCustomerName() );
                    row.createCell(1).setCellValue(couponExcel1.getCustomerId() == null ? "" : couponExcel1.getCustomerId());
                    row.createCell(2).setCellValue(couponExcel1.getCouponName() == null ? "" : couponExcel1.getCouponName());
                    row.createCell(3).setCellValue(couponExcel1.getDeductible() == null ? 0d : couponExcel1.getDeductible());
                    row.createCell(4).setCellValue(couponExcel1.getProductName() == null ? "" : couponExcel1.getProductName());
                    row.createCell(5).setCellValue(couponExcel1.getPeeAmount() == null ? 0d : couponExcel1.getPeeAmount().doubleValue());
                    row.createCell(6).setCellValue(couponExcel1.getDate_activation() == null ? "" : sdf.format(couponExcel1.getDate_activation()));
                    row.createCell(7).setCellValue(couponExcel1.getDate_consume() == null ? "" : sdf.format(couponExcel1.getDate_consume()));
                    row.createCell(8).setCellValue(couponExcel1.getShopId() == null ? "" : couponExcel1.getShopId());
                    row.createCell(9).setCellValue(couponExcel1.getCouponStatus() == null ? "" : couponExcel1.getCouponStatus());
                    h++;
                }
            }

            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fs != null) {
                try {
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(fileName + "完成！！！");
    }


    private int diffDays(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days + 1;
    }

    private String sheetName(int i) {
        if(i == 0) {
            return "1号 ~ 10号";
        } else if(i == 11) {
            return "11号 ~ 20号";
        } else if(i == 21) {
            return "21号 ~ 31号";
        }

        return "未知";
    }

}
