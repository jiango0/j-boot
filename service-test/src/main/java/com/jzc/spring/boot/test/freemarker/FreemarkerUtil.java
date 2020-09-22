package com.jzc.spring.boot.test.freemarker;

import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtil {

    public static String evaluate(Template template, Map<String, Object> data) {
        try {
            StringWriter out = new StringWriter();
            template.process(data, out);
            return out.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

}
