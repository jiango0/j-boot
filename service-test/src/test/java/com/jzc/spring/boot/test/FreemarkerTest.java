package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.boot.test.freemarker.FreemarkerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerTest {

    private String model = "[\n" +
            "    {\n" +
            "        \"_m\":{\n" +
            "            \"n\":\"order\",\n" +
            "            \"i\":\"${record.message.orderCode}\",\n" +
            "            \"p\":\"${record.message.shopId}\",\n" +
            "            \"o\":3\n" +
            "        },\n" +
            "\t\t<#list record.message?keys as key>\n" +
            "\t\t\t<#if !(record.message[key]?is_hash || record.message[key]?is_indexable)>\n" +
            "\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${record.message[key]!''}\"\n" +
            "\t\t\t</#if>\n" +
            "\t\t</#list>\n" +
            "    }\n" +
            "\t<#if record.message.orderBuyer??>\n" +
            "\t\t,{\n" +
            "\t\t\t\"_m\":{\n" +
            "\t\t\t\t\"n\":\"order_buyer\",\n" +
            "\t\t\t\t\"i\":\"${record.message.orderCode}\",\n" +
            "\t\t\t\t\"p\":\"${record.message.shopId}\",\n" +
            "\t\t\t\t\"o\":3\n" +
            "\t\t\t},\n" +
            "\t\t\t<#list record.message.orderBuyer?keys as key>\n" +
            "\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${record.message.orderBuyer[key]!''}\"\n" +
            "\t\t\t</#list>\n" +
            "\t\t}\n" +
            "\t</#if>\n" +
            "\t<#if record.message.orderPayment??>\n" +
            "\t\t,{\n" +
            "\t\t\t\"_m\":{\n" +
            "\t\t\t\t\"n\":\"order_payment\",\n" +
            "\t\t\t\t\"i\":\"${record.message.orderCode}\",\n" +
            "\t\t\t\t\"p\":\"${record.message.shopId}\",\n" +
            "\t\t\t\t\"o\":3\n" +
            "\t\t\t},\n" +
            "\t\t\t<#list record.message.orderPayment?keys as key>\n" +
            "\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${record.message.orderPayment[key]!''}\"\n" +
            "\t\t\t</#list>\n" +
            "\t\t}\n" +
            "\t</#if>\n" +
            "\t<#if record.message.orderShipping??>\n" +
            "\t\t,{\n" +
            "\t\t\t\"_m\":{\n" +
            "\t\t\t\t\"n\":\"order_shipping\",\n" +
            "\t\t\t\t\"i\":\"${record.message.orderCode}\",\n" +
            "\t\t\t\t\"p\":\"${record.message.shopId}\",\n" +
            "\t\t\t\t\"o\":3\n" +
            "\t\t\t},\n" +
            "\t\t\t<#list record.message.orderShipping?keys as key>\n" +
            "\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${record.message.orderShipping[key]!''}\"\n" +
            "\t\t\t</#list>\n" +
            "\t\t}\n" +
            "\t</#if>\n" +
            "\t<#if record.message.orderExt??>\n" +
            "\t\t,{\n" +
            "\t\t\t\"_m\":{\n" +
            "\t\t\t\t\"n\":\"order_ext\",\n" +
            "\t\t\t\t\"i\":\"${record.message.orderCode}\",\n" +
            "\t\t\t\t\"p\":\"${record.message.shopId}\",\n" +
            "\t\t\t\t\"o\":3\n" +
            "\t\t\t},\n" +
            "\t\t\t<#list record.message.orderExt?keys as key>\n" +
            "\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${record.message.orderExt[key]!''}\"\n" +
            "\t\t\t</#list>\n" +
            "\t\t}\n" +
            "\t</#if>\n" +
            "\t<#if record.message.orderDetailList??>\n" +
            "\t\t<#list record.message.orderDetailList as orderDetail>\n" +
            "\t\t\t,{\n" +
            "\t\t\t\t\"_m\":{\n" +
            "\t\t\t\t\t\"n\":\"order_detail\",\n" +
            "\t\t\t\t\t\"i\":\"${record.message.orderCode}_${orderDetail_index}\",\n" +
            "\t\t\t\t\t\"p\":\"${record.message.shopId}\",\n" +
            "\t\t\t\t\t\"o\":3\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"orderItemDetailList\":[\n" +
            "\t\t\t\t\t\t\t<#list orderDetail.orderItemDetailList as orderItemDetail>\n" +
            "\t\t\t\t\t\t\t\t<#if orderItemDetail_index != 0>,</#if>{\n" +
            "\t\t\t\t\t\t\t\t\t<#list orderItemDetail?keys as key>\n" +
            "\t\t\t\t\t\t\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${orderItemDetail[key]!''}\"\n" +
            "\t\t\t\t\t\t\t\t\t</#list>\n" +
            "\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t</#list>\n" +
            "\t\t\t\t\t\t]\n" +
            "\t\t\t\t<#list orderDetail?keys as key>\n" +
            "\t\t\t\t\t<#if !orderDetail[key]?is_indexable>\n" +
            "\t\t\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${orderDetail[key]!''}\"\n" +
            "\t\t\t\t\t</#if>\n" +
            "\t\t\t\t</#list>\n" +
            "\t\t\t}\n" +
            "\t\t</#list>\n" +
            "\t</#if>\n" +
            "\t<#if record.message.orderPaySummaryList??>\n" +
            "\t\t<#list record.message.orderPaySummaryList as orderPaySummary>\n" +
            "\t\t\t,{\n" +
            "\t\t\t\t\"_m\":{\n" +
            "\t\t\t\t\t\"n\":\"order_payment_summary\",\n" +
            "\t\t\t\t\t\"i\":\"${record.message.orderCode}_${orderPaySummary_index}\",\n" +
            "\t\t\t\t\t\"p\":\"${record.message.shopId}\",\n" +
            "\t\t\t\t\t\"o\":3\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t<#list orderPaySummary?keys as key>\n" +
            "\t\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${orderPaySummary[key]!''}\"\n" +
            "\t\t\t\t</#list>\n" +
            "\t\t\t}\n" +
            "\t\t</#list>\n" +
            "\t</#if>\n" +
            "]";

    String data = "{\"orderCode\":\"6875249648752213219\",\"shopId\":\"bce3c3bf-e627-4afe-a8d8-7dbdaf4584ca\",\"merchantId\":\"dwj\",\"orderChannel\":3,\"orderType\":10,\"orderDirection\":0,\"orderName\":\"5枚兑换券\",\"orderStatus\":1,\"shippedStatus\":0,\"payStatus\":0,\"shippedType\":0,\"goodsNum\":1,\"remark\":\"现金付款\",\"creator\":\"刘青\",\"orderAt\":\"2020-09-22 18:00:01.995\",\"updatedAt\":\"2020-09-22 18:00:01.995\",\"orderDetailList\":[{\"orderDetailId\":\"6b6913eb-830b-478d-8ebe-fb0b9eee6f40\",\"goodsSku\":\"6b6913eb-830b-478d-8ebe-fb0b9eee6f40\",\"goodsType\":0,\"goodsCategory\":\"01-0102\",\"goodsName\":\"5枚兑换券\",\"goodsQty\":\"1\",\"orderItemDetailList\":[{\"goodsPrice\":\"0.0\",\"priceType\":0,\"amountTotal\":\"0.0\",\"amountDiscount\":\"0.0\",\"amountPayable\":\"0.0\",\"amountShare\":\"0.0\",\"discount\":\"0\"}],\"subOrderDetailList\":[{\"orderDetailId\":\"fe6f4cdf-0a43-4c98-8c0a-6657bdf4bf4a\",\"goodsSku\":\"BI20190001\",\"goodsType\":0,\"goodsCategory\":\"01-0101\",\"goodsName\":\"游戏币\",\"goodsQty\":\"5\"}]}],\"orderShipping\":{\"shippingType\":\"normal_goods\",\"subShippingType\":0},\"orderBuyer\":{\"memberType\":\"2\",\"rightsType\":0},\"orderPayment\":{\"payType\":4,\"payFlag\":1},\"orderPaySummaryList\":[{\"priceType\":0,\"amountDiscount\":\"0\",\"amountPayable\":\"0.0\",\"amountTotal\":\"0.0\"}],\"orderExt\":{\"member_id\":null,\"birthday\":null,\"cashier_code\":\"0c6a36fb-4c3b-42a3-8318-49d4eaa7d760\",\"gender\":null,\"sourceProduct\":0,\"mobileNumber\":null,\"bizCode\":\"1152110\",\"shopName\":\"上海青浦万达店\",\"memberName\":null,\"give_amount\":0,\"device_num\":\"97a7d894-748b-451b-ad4f-ef7d8ededd2a\",\"cashier_name\":\"刘青\",\"appletMobile\":null,\"idNumber\":null,\"cardNo\":null,\"sale_quantity\":5,\"member_level\":null,\"order_category\":0,\"device_name\":\"POS机1号\",\"brandId\":\"c2e802ba-0c6b-2460-8ec4-9cb810c92b6c\",\"busType\":\"CASH_CONVERT_COUPON\",\"goodsName\":\"5枚兑换券\",\"member_level_name\":null,\"give_quantity\":5}}";

    @Test
    public void test() throws IOException {

        Template filterTemplate = new Template("1", model, new Configuration());

        Map map = JSON.parseObject(data, Map.class);

        Map param = new HashMap(){{
            put("record", new HashMap(){{
                put("message", map);
            }});
        }};

        String evaluate = FreemarkerUtil.evaluate(filterTemplate, param);

        System.out.println(evaluate);

    }


}
