package com.cmb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.toonyoo.pay.sdk.cmb.BillClient;
import com.toonyoo.pay.sdk.cmb.CmbClient;
import com.toonyoo.pay.sdk.cmb.DefaultCmbClient;
import com.toonyoo.pay.sdk.cmb.NetPosClient;
import com.toonyoo.pay.sdk.cmb.request.*;
import com.toonyoo.pay.sdk.cmb.response.*;
import com.toonyoo.pay.sdk.cmb.util.BeanUtil;
import com.toonyoo.pay.sdk.cmb.util.RSAUtil;
import com.toonyoo.pay.sdk.cmb.util.TransactionConstant;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SMTest {

    private String serviceUrl = "https://ipaynow.acquire.cmbchina.com";

    private String charset = "UTF-8";

    private String mhtSignType = "MD5";

    String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCi8ABdV+C5c5Dg5h48DRr7Wip1++3RzseMO7mD/gQ95hs3bQ6n/afZrZw9WRmi4J2JgUIUOQuwRuan+gzSdTzqbxDNH/2Wl8hem+LuGupeFNWbmIly3hEtw3AuwvV3kV7gIwPjdWWWa/uMzV4lxc64N0/5Mvw8HJMPhcCbE9NNz7g1r4CXJXoIa1hElA8XT3sVgXHAPYhjZ0LFRP7C0piXHNJAaYeDJYaSlQ2t7fRUflsa03jaSr471t7HlgzH9P5emcBuNs+4st9zX1Zz6xzIhnfrsXXVjXwZ2E69zQBSsVRBJ7PDk5TGfDL1Iwx0bSjbcSOsttxtGoamT528OfoDAgMBAAECggEABVryCB9dSXsc5edqUvrzShOalaokFONA98D2xfnRVd98QYQaGTdjDup/2hxVlV7gjqZq75M4aSDLb/Xt+fTUfbgMy1Ej2pE+iq2A9eZ4kYMJykVnLxlRYzmrND5AJx/mCGPeOtme7yS5bdVKJN+tfayDumMMm0UtKDNzMyWhqkr9+z1K6TmUsdbERbKpxnvvXPSQASAh/TfzoPRbool3jtrCVEGQci8pBV06r/95y4qr2W6ucWaRTHUrK3CHqGm+NjrNisotlSWP4dKKSPquCrn/toYPcEVajQuyKg//8t7XC+SXr+YHZFm1BAjLjZSbtcnJ2w/SnKwgdNu4YFGd4QKBgQDheAi+u0yLBX5GOSA12Re9W41eu7bcXZdpgVpm4JTusZ+70/xkwQt3xdpL71k512F0iNcwNa+s7GOnS/kPZ8uXKX5lHdeiijy8tIiJR13pvOA3w+5MFEtMxkJLgnHjtBtYZi3C0Ytqf9RWpp4pSQljTGTCXJYNLcUqEVRZ2nH82wKBgQC5AEr8++DJhjLwtj7nmzEaj2oYhZRTcE6tqLOde2y3aC84SylO//Mrf6+UMsupQOuIMS36MXCspH17ZFrHi0GS8m5XFXTDP61lnI96wAwCJoEeGj2U6sLrTDAiZh818xzEn1tybp55YlXuKiyDVTSN4/dEc1h4MPvaccgDdhrr+QKBgCoN+ZOZ2+0SWTs/7IIevA7VxMimurTfwB4twm7t9NmQx/qAz9L7LuhoPw9q1Xm0crkJzRlw6hOXA/9wbEQzWAYZ9zllF5N5tVp9UfpJFXtDf47nPMtz/ZeUY0kyS4vtTCxw4pgz/Y0fyrte2KFaviWHWkPmgRZ0MxJlqRYZaKmBAoGAAKKYn0+6ENcOG7d0ddUZkQ7G/XiP7s1m57+5hiPjVqnb56SSarwEOLUChE68VkNry5bnooFC8sTJzX+ltCOtQPTmHhRrxzPTw5KLB4/bOrKpJNJQPc+khaxISgXxu3yvL5mgdb8deis1QlEQwA6t1ILg2XJP7nG0m6ZiWmiwZPkCgYAnD5cv++U4MyT4+agluwyH86hipFAjUMVKGzPWlcRaGDDRrfdk0BG2o5gkqAWg+dO3vcRK8LFfqs3EMb0asGt0yCb/8nQbZYwXKWSclxSyNnBXMPCsg76H+MY8/2oligebEGV+lIUnpsEHVPVISUyorKNflbO7ANKvIJqv2z1gEQ==";

    @Test
    public void ZSM() {

        CmbClient client = new DefaultCmbClient(serviceUrl, "155729479448468", "uwfRkx9eMCnzqd5CCBC1v3srVD9ClQwh", charset, mhtSignType);

        CmbNativePayRequest request = new CmbNativePayRequest();

        request.setVersion("1.0.0");
        request.setMhtOrderNo("201905210905211002");
        request.setMhtOrderName("测试支付宝");
        request.setMhtOrderType("05");
        request.setMhtCurrencyType("156");
        request.setMhtOrderAmt("1");
        request.setMhtOrderDetail("mhtOrderDetail");
        request.setMhtOrderTimeOut("3600");
        request.setMhtOrderStartTime("20190605144228");
        request.setNotifyUrl("https://4cae79ed.ngrok.io/api/pay/notify/cmb/40ed3fb4-6b8a-4606-9cb3-a1e8bba5584b/0345981E-F0F7-44E5-8E9A-3480DB5C821B/1559716726014");
        request.setPayChannelType("12");
        request.setMhtReserved("1");
        request.setOutputType("0");
        request.setSignTypeFlag(Boolean.TRUE);

        System.out.println(JSON.toJSONString(request));

        CmbNativePayResponse execute = client.execute(request);

        System.out.println(JSON.toJSON(execute));

    }

    @Test
    public void BSM() {

        CmbClient client = new DefaultCmbClient(serviceUrl, "155729488653674", "N6h3kd0yeFUZdxEpw3XVRuX9KEYGwmr7", charset, mhtSignType);

        CmbQrCodePayRequest request = new CmbQrCodePayRequest();

        request.setVersion("1.0.0");
        request.setChannelAuthCode("135205771624605111");
        request.setMhtOrderNo("TS" + new Date().getTime());
        request.setMhtOrderName("BM测试支付");
        request.setMhtOrderType("05");
        request.setMhtCurrencyType("156");
        request.setMhtOrderAmt("1");
        request.setMhtOrderDetail("mhtOrderDetail");
        request.setMhtOrderTimeOut("3600");
        request.setMhtOrderStartTime("20190507182300");
        request.setNotifyUrl("");
        request.setPayChannelType("13");
        request.setMhtReserved("");
        request.setMhtSubAppId("");

        CmbQrCodePayResponse execute = client.execute(request);

        System.out.println(JSON.toJSON(execute));

    }

    @Test
    public void GZH() {

        CmbClient client = new DefaultCmbClient(serviceUrl, "155729470114820", "q3z4b7oM21VoXLBGzmEVz0f9OAASIBAf", charset, mhtSignType);

        CmbOfficialAccountsPayRequest request = new CmbOfficialAccountsPayRequest();

        request.setVersion("1.0.0");
        request.setMhtOrderNo("TS" + new Date().getTime());
        request.setMhtOrderName("测试公众号");
        request.setMhtOrderType("05");
        request.setMhtCurrencyType("156");
        request.setMhtOrderAmt("1");
        request.setMhtOrderDetail("mhtOrderDetail");
        request.setMhtOrderStartTime("20190606112300");
        request.setNotifyUrl("https://fe402dfb.ngrok.io/notify");
//        request.setFrontNotifyUrl("");
        request.setPayChannelType("13");
        request.setMhtReserved("");
        request.setOutputType("1");
        request.setMhtSubAppId("wx3b88ed66fc71a633");
        request.setConsumerId("ojmh309mU4vmjo3oJC0VIWD855EM");
        request.setMhtLimitPay("0");
        request.setSignTypeFlag(Boolean.TRUE);

        System.out.println("request data : " + JSON.toJSON(request));

        CmbOfficialAccountsPayResponse execute = client.execute(request);

        System.out.println("response data : " + JSON.toJSON(execute));

    }

    @Test
    public void CXT() {

        CmbClient client = new DefaultCmbClient(serviceUrl, "155729479448468", "uwfRkx9eMCnzqd5CCBC1v3srVD9ClQwh", charset, mhtSignType);

        CmbCancelRequest request = new CmbCancelRequest();

//        request.setVersion("1.0.0");
        request.setMhtOrderNo("TS1559188398252");
        request.setMhtRefundNo("TS1559188398252001");
        request.setReason("1");

        System.out.println("request data : " + JSON.toJSON(request));

        CmbCancelResponse response = client.execute(request);

        System.out.println("response data : " + JSON.toJSON(response));

    }

    @Test
    public void TKT() {

        CmbClient client = new DefaultCmbClient(serviceUrl, "155729479448468", "uwfRkx9eMCnzqd5CCBC1v3srVD9ClQwh", charset, mhtSignType);

        CmbRefundRequest request = new CmbRefundRequest();

//        request.setVersion("1.0.0");
        request.setMhtOrderNo("1559115875191");
        request.setMhtRefundNo("1559115875191001");
        request.setReason("1");
        request.setAmount("1");

        System.out.println("request data : " + JSON.toJSON(request));

        CmbRefundResponse response = client.execute(request);

        System.out.println("response data : " + JSON.toJSON(response));

    }

    @Test
    public void CMBQ() {

        CmbClient client = new DefaultCmbClient(serviceUrl, "155729488653674", "N6h3kd0yeFUZdxEpw3XVRuX9KEYGwmr7", charset, mhtSignType);

        CmbStatusQueryRequest request = new CmbStatusQueryRequest();

        request.setVersion("1.0.0");
        request.setDeviceType("05");
        request.setMhtOrderNo("6714121678605114984");
        request.setSignTypeFlag(Boolean.TRUE);

        CmbStatusQueryResponse response = client.execute(request);

        String jsonStr = JSON.toJSONString(response);

        System.out.println("response data : " + jsonStr);
    }

    @Test
    public void NPTQ() {

        NetPosClient client = new NetPosClient(serviceUrl, "713337500010001", charset, "RSA2", privateKey);

        NetPosStatusQueryRequest request = new NetPosStatusQueryRequest();
        request.setVersion("2.0.0");
        request.setMhtOrderNo("1559115875191");
        request.setTradeSubmitDate("20190618115800");
        request.setTransId("1");

        NetPosStatusQueryResponse response = client.execute(request);

        String jsonStr = JSON.toJSONString(response);

        System.out.println("response data : " + jsonStr);

    }

    @Test
    public void THSQ() {

        NetPosClient client = new NetPosClient(serviceUrl, "713337500010001", charset, "RSA2", privateKey);

        NetPosRefundRequest request = new NetPosRefundRequest();
        request.setVersion("2.0.0");
        request.setOriMhtOrderNo("1559115875191");
        request.setOriTransId("1559115875191");
        request.setMhtRefundNo("1559115875191");
        request.setRefundAmt(1L);
        request.setReason("111");

        NetPosRefundResponse response = client.execute(request);

        String jsonStr = JSON.toJSONString(response);

        System.out.println("response data : " + jsonStr);

    }

    @Test
    public void billToken() {

        CmbBillTokenRequest request = new CmbBillTokenRequest();
        request.setMhtAcc("xuyongyan@flyhigh.com.cn");
        request.setTimestamp( String.valueOf(System.currentTimeMillis()));
        request.setTokenTime("3600");
        request.setVersion("1.0.0");

        BillClient billClient = new BillClient("https://mch.aggreg.cmbchina.com/clond_bill/service", "000000010001264", "M0GvToj0HpmcLO6KIadVYXnIi2BjMuA3", "UTF-8", "MD5");

        CmbBillTokenResponse response = billClient.execute(request);

        System.out.println("response data : " + JSONObject.toJSONString(response));

    }

    @Test
    public void billSummary() {
        CmbBillSummaryRequest request = new CmbBillSummaryRequest();
        request.setBillType("D01");
        request.setBillDate("20190620");
        request.setAccessToken("a5088b86460f84582f4fe03a4d626451");
        request.setTimestamp( String.valueOf(System.currentTimeMillis()));
        request.setVersion("1.0.0");

        BillClient billClient = new BillClient("https://mch.aggreg.cmbchina.com/clond_bill/service", "000000010001264", "M0GvToj0HpmcLO6KIadVYXnIi2BjMuA3", "UTF-8", "MD5");

        CmbBillSummaryResponse response = billClient.execute(request);

        System.out.println("response data : " + JSONObject.toJSONString(response));

    }

    @Test
    public void billDownload() throws IOException {

        CmbBillDownloadRequest request = new CmbBillDownloadRequest();
        request.setMagzineId("201906211400381197555");
        request.setAccessToken("a5088b86460f84582f4fe03a4d626451");
        request.setTimestamp( String.valueOf(System.currentTimeMillis()));
        request.setVersion("1.0.0");

        BillClient billClient = new BillClient("https://mch.aggreg.cmbchina.com/clond_bill/service", "000000010001264", "M0GvToj0HpmcLO6KIadVYXnIi2BjMuA3", "UTF-8", "MD5");

        CmbBillDownloadResponse response = billClient.execute(request);

        System.out.println("response data : " + response.getInputStream().available());

    }


}
