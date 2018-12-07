package com.jzc.spring.boot.integral;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=IntegralSupplementTest.class)
public class IntegralSupplementTest {

    static Map<String, String> orderCustomerMap = new HashMap<>();

    static List<Map<String, Object>> list = new ArrayList<>();

    static {
        try {
            XSSFWorkbook wb = new XSSFWorkbook( new FileInputStream(ResourceUtils.getFile("classpath:excel/integral_supplement.xlsx")) );
            XSSFSheet sheet0 = wb.getSheetAt(0);
            XSSFSheet sheet1 = wb.getSheetAt(1);

            int i = 1;
            for(;;i++) {
                XSSFRow row = sheet1.getRow(i);
                if(row == null) {
                    break;
                }
                XSSFCell cell0 = row.getCell(0);
                XSSFCell cell1 = row.getCell(1);
                if(StringUtils.isEmpty(cell0.getStringCellValue()) ) {
                   break;
                }
                orderCustomerMap.put(cell0.getStringCellValue(), cell1.getStringCellValue());
            }

            i = 1;
            for(;;i++) {
                XSSFRow row = sheet0.getRow(i);
                if(row == null) {
                    break;
                }
                XSSFCell orderId = row.getCell(0);
                if(StringUtils.isEmpty(orderId)) {
                    break;
                }

                XSSFCell partnerId = row.getCell(1);
                XSSFCell shopId = row.getCell(2);
                XSSFCell payPrice = row.getCell(3);
                XSSFCell createTime = row.getCell(4);

                Map<String, Object> map = new HashMap<>();
                map.put("orderId", orderId);
                map.put("partnerId", partnerId);
                map.put("shopId", shopId);
                map.put("payPrice", payPrice);
                map.put("createTime", createTime);

                list.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void integralSuppement() throws Exception {
        System.out.println(orderCustomerMap.size());
        System.out.println(list.size());
        int i = 0;
        for(Map<String, Object> map : list) {
            String orderId = map.get("orderId") == null ? null : map.get("orderId").toString();
            String partnerId = map.get("orderId") == null ? null : map.get("partnerId").toString();
            String shopId = map.get("orderId") == null ? null : map.get("shopId").toString();
            BigDecimal payPrice = map.get("payPrice") == null ? new BigDecimal(0) : new BigDecimal(map.get("payPrice").toString()).setScale(0, BigDecimal.ROUND_HALF_UP);
            String customerId = orderCustomerMap.get(orderId);

            this.sendIntegralInfo(orderId, partnerId, shopId, payPrice.intValue(), customerId);
            i++;
            Thread.sleep(200);
        }
        System.out.println(i);

    }

    /**
     * {
         "partner_sign":"A0B2D274-A809-4F9F-A895-79A966CE54EA",
         "amount":"7014",
         "order_code":"2018091715542321",
         "type":"9",
         "customer_id":"8D7F87A2-CCF6-429D-8190-954BC90CB194",
         "source":"系统增加积分",
         "shop_guid":"E2B908D3-FD85-43B0-B35D-38BC1B6E8032"
         }
     *
     * */
    private void sendIntegralInfo(String orderId, String partnerSign, String shopGuid, Integer amount, String customerId) throws Exception {

//        String url = "http://boss.toonyoo.net/membermanagement/integral/list/add";
        String url = "";
        Map<String, Object> map = new HashMap<String, Object>(){{
            put("partner_sign", partnerSign);
            put("amount", amount);
            put("order_code", orderId);
            put("type", 0);
            put("customer_id", customerId);
            put("source", "系统批量增加积分");
            put("shop_guid", shopGuid);
        }};
        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(JSON.toJSONString(map), "utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json");

        CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
        System.out.println(JSON.toJSONString(response));
        int status = response.getStatusLine().getStatusCode();
        if (status == HttpStatus.SC_OK) {
            // 获取响应结果
            System.out.println("resultJson : " + EntityUtils.toString(response.getEntity(), "UTF-8") );
        } else {
            System.out.println("响应失败，状态码：" + status);
        }

    }

}
