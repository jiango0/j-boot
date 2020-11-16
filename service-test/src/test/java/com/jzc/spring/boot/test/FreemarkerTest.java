package com.jzc.spring.boot.test;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.boot.test.freemarker.FreemarkerUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
            "\t\t\t}\n" +
            "\t\t\t<#list record.message.orderPayment?keys as key>\n" +
            "\t\t\t\t,\"${key}\":\"${record.message.orderPayment[key]!''}\"\n" +
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
            "\t\t\t}\n" +
            "\t\t\t<#list record.message.orderShipping?keys as key>\n" +
            "\t\t\t\t,\"${key}\":\"${record.message.orderShipping[key]!''}\"\n" +
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
            "\t\t\t}\n" +
            "\t\t\t<#list record.message.orderExt?keys as key>\n" +
            "\t\t\t\t,\"${key}\":\"${record.message.orderExt[key]!''}\"\n" +
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
            "\t\t\t\t<#list orderDetail?keys as key>\t\n" +
            "\t\t\t\t\t<#if key_index != 0>,</#if>\n" +
            "\t\t\t\t\t<#switch key>\n" +
            "\t\t\t\t\t\t <#case \"orderItemDetailList\">\n" +
            "\t\t\t\t\t\t\t\"orderItemDetailList\":[\n" +
            "\t\t\t\t\t\t\t\t<#list orderDetail.orderItemDetailList as orderItemDetail>\n" +
            "\t\t\t\t\t\t\t\t\t<#if orderItemDetail_index != 0>,</#if>{\n" +
            "\t\t\t\t\t\t\t\t\t\t<#list orderItemDetail?keys as k>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<#if k_index != 0>,</#if>\"${k}\":\"${orderItemDetail[k]!''}\"\n" +
            "\t\t\t\t\t\t\t\t\t\t</#list>\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t</#list>\n" +
            "\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t <#break>\n" +
            "\t\t\t\t\t\t <#case \"subOrderDetailList\">\n" +
            "\t\t\t\t\t\t\t\"subOrderDetailList\":[\n" +
            "\t\t\t\t\t\t\t\t<#list orderDetail.subOrderDetailList as subOrderItemDetail>\n" +
            "\t\t\t\t\t\t\t\t\t<#if subOrderItemDetail_index != 0>,</#if>{\n" +
            "\t\t\t\t\t\t\t\t\t\t<#list subOrderItemDetail?keys as k>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<#if k_index != 0>,</#if>\"${k}\":\"${subOrderItemDetail[k]!''}\"\n" +
            "\t\t\t\t\t\t\t\t\t\t</#list>\n" +
            "\t\t\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t\t\t</#list>\n" +
            "\t\t\t\t\t\t\t]\n" +
            "\t\t\t\t\t\t <#break>\n" +
            "\t\t\t\t\t\t <#default>\"${key}\":\"${orderDetail[key]!''}\"\n" +
            "\t\t\t\t\t</#switch>\n" +
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
            "\t\t\t\t\"orderCode\":\"${record.message.orderCode}\",\n" +
            "\t\t\t\t\"orderStatus\":\"${record.message.orderStatus!0}\",\n" +
            "\t\t\t\t\"shippedStatus\":\"${record.message.shippedStatus!0}\",\n" +
            "\t\t\t\t\"payStatus\":\"${record.message.payStatus!0}\",\n" +
            "\t\t\t\t<#list orderPaySummary?keys as key>\n" +
            "\t\t\t\t\t<#if key_index != 0>,</#if>\"${key}\":\"${orderPaySummary[key]!''}\"\n" +
            "\t\t\t\t</#list>\n" +
            "\t\t\t}\n" +
            "\t\t</#list>\n" +
            "\t</#if>\n" +
            "]";

    String data = "{\"orderCode\":\"6875585536669618568\",\"shopId\":\"11885493-d1b2-48d4-a43c-8142c005e5b1\",\"merchantId\":\"dwj\",\"orderChannel\":1,\"orderType\":3,\"orderDirection\":0,\"orderName\":\"lyz购币套餐1\",\"orderStatus\":1,\"shippedStatus\":0,\"payStatus\":0,\"shippedType\":1,\"goodsNum\":1,\"remark\":\"一体机下单\",\"creator\":\"一体机\",\"orderAt\":\"2020-09-23 15:43:27\",\"updatedAt\":\"2020-09-23 15:43:27\",\"orderDetailList\":[{\"orderDetailId\":\"74b1b023-1574-4b0d-bac8-60e7f2f5c9b4\",\"goodsSku\":\"1000192\",\"goodsType\":0,\"goodsCategory\":\"01-0104-010401\",\"goodsName\":\"lyz购币套餐1\",\"goodsQty\":1,\"orderItemDetailList\":[{\"goodsPrice\":1.0,\"priceType\":0,\"amountTotal\":1.0,\"amountDiscount\":0.0,\"amountPayable\":1.0,\"amountShare\":1.0}],\"subOrderDetailList\":[{\"orderDetailId\":\"7403f59b-4a62-462e-92af-5d3ba6af00fc\",\"goodsSku\":\"BI20190001\",\"goodsType\":0,\"goodsCategory\":\"01-0101\",\"goodsName\":\"游戏币\",\"goodsQty\":1}]}],\"orderShipping\":{\"shippingType\":\"virtual_goods\"},\"orderBuyer\":{\"memberType\":\"1\",\"memberId\":\"850060033907\",\"memberCardId\":\"CS03312370\",\"memberLevel\":\"3\"},\"orderPayment\":{},\"orderPaySummaryList\":[{\"priceType\":0,\"amountDiscount\":0,\"amountPayable\":1.0,\"amountTotal\":1.0}]}";

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

    @Test
    public void test2() throws IOException {

        String _model = "${(dbName==\"ty_app_message\" && tableName == \"message\" && eventType == \"2\")?c}";
        String data = "{\"dbName\":\"ty_app_message\",\"tableName\":\"message\",\"pv\":\"03608f84-bc88-4ad4-b365-1efcb35b0f71\",\"eventType\":2,\"executeTime\":\"2020-09-24 18:11:13\",\"dateCreated\":\"2020-09-24 18:11:13\",\"logfileName\":\"binlog.000003\",\"logfileOffset\":189063778,\"beforeColumns\":{\"message_status\":{\"name\":\"message_status\",\"value\":\"0\",\"sqlType\":4,\"valueBytes\":\"MA==\",\"key\":false,\"null\":false,\"updated\":false},\"receiver\":{\"name\":\"receiver\",\"value\":\"640010488308\",\"sqlType\":12,\"valueBytes\":\"NjQwMDEwNDg4MzA4\",\"key\":false,\"null\":false,\"updated\":false},\"sender\":{\"name\":\"sender\",\"value\":\"系统\",\"sqlType\":12,\"valueBytes\":\"57O757uf\",\"key\":false,\"null\":false,\"updated\":false},\"receiver_name\":{\"name\":\"receiver_name\",\"value\":\"地方1\",\"sqlType\":12,\"valueBytes\":\"5Zyw5pa5MQ==\",\"key\":false,\"null\":false,\"updated\":false},\"message_id\":{\"name\":\"message_id\",\"value\":\"03608f84-bc88-4ad4-b365-1efcb35b0f71\",\"sqlType\":12,\"valueBytes\":\"MDM2MDhmODQtYmM4OC00YWQ0LWIzNjUtMWVmY2IzNWIwZjcx\",\"key\":true,\"null\":false,\"updated\":false},\"sender_name\":{\"name\":\"sender_name\",\"value\":\"系统\",\"sqlType\":12,\"valueBytes\":\"57O757uf\",\"key\":false,\"null\":false,\"updated\":false},\"merchant_id\":{\"name\":\"merchant_id\",\"value\":\"dwj\",\"sqlType\":12,\"valueBytes\":\"ZHdq\",\"key\":false,\"null\":false,\"updated\":false},\"title\":{\"name\":\"title\",\"value\":\"优惠券到期提醒\",\"sqlType\":12,\"valueBytes\":\"5LyY5oOg5Yi45Yiw5pyf5o+Q6YaS\",\"key\":false,\"null\":false,\"updated\":false},\"create_at\":{\"name\":\"create_at\",\"value\":\"2020-01-09 01:00:00\",\"sqlType\":93,\"valueBytes\":\"MjAyMC0wMS0wOSAwMTowMDowMA==\",\"key\":false,\"null\":false,\"updated\":false},\"content\":{\"name\":\"content\",\"value\":\"尊敬的用户您好，您有优惠券即将到期 ，请在有效期内使用。\",\"sqlType\":2005,\"valueBytes\":\"5bCK5pWs55qE55So5oi35oKo5aW977yM5oKo5pyJ5LyY5oOg5Yi45Y2z5bCG5Yiw5pyfIO+8jOivt+WcqOacieaViOacn+WGheS9v+eUqOOAgg==\",\"key\":false,\"null\":false,\"updated\":false},\"change_at\":{\"name\":\"change_at\",\"value\":\"\",\"sqlType\":93,\"valueBytes\":\"\",\"key\":false,\"null\":true,\"updated\":false}},\"afterColumns\":{\"message_status\":{\"name\":\"message_status\",\"value\":\"0\",\"sqlType\":4,\"valueBytes\":\"MA==\",\"key\":false,\"null\":false,\"updated\":false},\"receiver\":{\"name\":\"receiver\",\"value\":\"640010488308\",\"sqlType\":12,\"valueBytes\":\"NjQwMDEwNDg4MzA4\",\"key\":false,\"null\":false,\"updated\":false},\"sender\":{\"name\":\"sender\",\"value\":\"系统\",\"sqlType\":12,\"valueBytes\":\"57O757uf\",\"key\":false,\"null\":false,\"updated\":false},\"receiver_name\":{\"name\":\"receiver_name\",\"value\":\"地方12\",\"sqlType\":12,\"valueBytes\":\"5Zyw5pa5MTI=\",\"key\":false,\"null\":false,\"updated\":true},\"message_id\":{\"name\":\"message_id\",\"value\":\"03608f84-bc88-4ad4-b365-1efcb35b0f71\",\"sqlType\":12,\"valueBytes\":\"MDM2MDhmODQtYmM4OC00YWQ0LWIzNjUtMWVmY2IzNWIwZjcx\",\"key\":true,\"null\":false,\"updated\":false},\"sender_name\":{\"name\":\"sender_name\",\"value\":\"系统\",\"sqlType\":12,\"valueBytes\":\"57O757uf\",\"key\":false,\"null\":false,\"updated\":false},\"merchant_id\":{\"name\":\"merchant_id\",\"value\":\"dwj\",\"sqlType\":12,\"valueBytes\":\"ZHdq\",\"key\":false,\"null\":false,\"updated\":false},\"title\":{\"name\":\"title\",\"value\":\"优惠券到期提醒\",\"sqlType\":12,\"valueBytes\":\"5LyY5oOg5Yi45Yiw5pyf5o+Q6YaS\",\"key\":false,\"null\":false,\"updated\":false},\"create_at\":{\"name\":\"create_at\",\"value\":\"2020-01-09 01:00:00\",\"sqlType\":93,\"valueBytes\":\"MjAyMC0wMS0wOSAwMTowMDowMA==\",\"key\":false,\"null\":false,\"updated\":false},\"content\":{\"name\":\"content\",\"value\":\"尊敬的用户您好，您有优惠券即将到期 ，请在有效期内使用。\",\"sqlType\":2005,\"valueBytes\":\"5bCK5pWs55qE55So5oi35oKo5aW977yM5oKo5pyJ5LyY5oOg5Yi45Y2z5bCG5Yiw5pyfIO+8jOivt+WcqOacieaViOacn+WGheS9v+eUqOOAgg==\",\"key\":false,\"null\":false,\"updated\":false},\"change_at\":{\"name\":\"change_at\",\"value\":\"\",\"sqlType\":93,\"valueBytes\":\"\",\"key\":false,\"null\":true,\"updated\":false}},\"itemNo\":0,\"gtid\":\"\",\"ddl\":false}";
        Template filterTemplate = new Template("2", _model, new Configuration());

        List map = JSON.parseObject(data, List.class);

        for (int i=0; i<map.size(); i++) {
            Object o = map.get(i);
            Map map1 = JSON.parseObject(JSON.toJSONString(o), Map.class);
//            Map param = new HashMap(){{
//                put("record", map1);
//            }};

            String evaluate = FreemarkerUtil.evaluate(filterTemplate, map1);

            System.out.println(evaluate);
        }

    }

    @Test
    public void test3() throws IOException {
        String _model = "[ \t{ \t\t\"_m\":{ \t\t\t\"n\":\"message_count_sum\", \t\t\t\"i\":\"${record._m.i}\", \t\t\t\"p\":\"<#if record._m.p??>${record._m.p}<#else>null</#if>\", \t\t\t\"o\":\"<#if record._m.o??>${record._m.o}<#else>null</#if>\" \t\t}, \t\t\"merchant_id\": \"<#if record._m.p??>${record._m.p}<#else>null</#if>\",  \t\t\"amount\": ${message_count_code.sum[0]},  \t\t\"_key\" : { \"merchant_id\": \"<#if record._m.p??>${record._m.p}<#else>null</#if>\" } \t} ]";
        String data = "{\"getCacheData\":{},\"message_count_code\":{\"sum\":[1000]},\"record\":{\"_m\":{\"n\":\"message_count\",\"i\":\"0b29e864-6717-4b7e-93e7-b292b1d1a0a3\",\"p\":\"dwj\",\"o\":\"1\"},\"merchant_id\":\"dwj\",\"title\":\"1601026179250\",\"content\":\"1601026179250\",\"message_status\":\"0\",\"sender\":\"\",\"sender_name\":\"\",\"create_at\":\"2020-09-25 17:29:39\",\"receiver\":\"6\",\"receiver_name\":\"接受者J6\",\"count\":1,\"getCacheData\":{}},\"_m\":{\"p\":\"s|message_count_code|dwj\"}}";
        Template filterTemplate = new Template("2", _model, new Configuration());

        String evaluate = FreemarkerUtil.evaluate(filterTemplate, JSON.parseObject(data, Map.class));

        System.out.println(evaluate);

    }


}
