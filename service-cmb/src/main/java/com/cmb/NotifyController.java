package com.cmb;

import com.toonyoo.pay.sdk.cmb.util.FormDateReportConvertor;
import com.toonyoo.pay.sdk.cmb.util.MD5Facade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NotifyController {

    @RequestMapping(value = "notify", method = {RequestMethod.POST, RequestMethod.GET})
    public void notify(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //获取通知数据需要从body中流式读取
        BufferedReader reader = req.getReader();
        StringBuilder reportBuilder = new StringBuilder();
        String tempStr = "";
        while((tempStr = reader.readLine()) != null){
            reportBuilder.append(tempStr);
        }
        String reportContent = reportBuilder.toString();
        System.out.println("reportContent：" + reportContent);
        Map<String,String> dataMap = FormDateReportConvertor.parseFormDataPatternReportWithDecode(reportContent, "UTF-8", "UTF-8");
        System.out.println("dataMap：" + dataMap.toString());

//        Map<String,String> dataMap = new HashMap<>();
//        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String key = parameterNames.nextElement();
//            String value = req.getParameter(key);
//
//            dataMap.put(key, value);
//        }
//        System.out.println("dataMap：" + dataMap.toString());

        //去除签名值
        String signature = dataMap.remove("signature");

        //验证签名
        boolean isValidSignature = MD5Facade.validateFormDataParamMD5(dataMap,"uwfRkx9eMCnzqd5CCBC1v3srVD9ClQwh",signature);

        System.out.println("验签结果："+isValidSignature);

        //一定要返回
        if(isValidSignature)
            resp.getOutputStream().write("success=Y".getBytes());
        else
            resp.getOutputStream().write("success=N".getBytes());
    }

}
