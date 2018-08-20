package com.jzc.spring.boot.test.garble;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

public class EcodeGarble {

    private Random random = new Random();

    //缓存对象
    private Map<String, CodePattern> cache = new HashMap();

    public String generateCode(String pattern, long seq) {
        if(seq == 0) {
            return null;
        }
        String s = String.valueOf(seq);
        if(StringUtils.isBlank(pattern)) {
            return s;
        }
        //获取codePattern
        CodePattern codePattern = this.patternCache(pattern);
        //如seq小于maxValue的长度，补0占位
        if(s.length() < codePattern.getDigitCount() ) {
            s = String.format("%0" + codePattern.getDigitCount() + "d", seq);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int[] rule = codePattern.getRule();
        for (int i = 0; i < rule.length; i++) {
            if( rule[i] == -1 ) {
                int random = this.random.nextInt(10);
                stringBuffer.append( (i == 0 && random == 0) ? 1 : random );
            } else {
                stringBuffer.append(s.charAt(rule[i] -1));
            }
        }

        return stringBuffer.toString();
    }

    private CodePattern patternCache(String pattern) {
        pattern = pattern.toLowerCase();
        //判断是否存在缓存，如果存在直接获取缓存中的 CodePattern
        if(cache.get(pattern) != null ) {
            return cache.get(pattern);
        }
        //判断pattern是否有效
        if( !Pattern.matches("^(([a-f1-9r]){1,})$", pattern) ) {
            throw new RuntimeException("Invalid code pattern");
        }
        //统计随机数位数与序号位数
        int[] rule = new int[pattern.length()];
        int digitCount = 0;
        int maxValue = 0;
        Set<Integer> digitSet = new HashSet();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if('r' == c) {
                rule[i] = -1;
            } else {
                rule[i] = Integer.parseInt(String.valueOf(c), 16);
                digitCount++;
                if (rule[i] > maxValue) {
                    maxValue = rule[i];
                }
                digitSet.add(rule[i]);
            }
        }
        //判断序号是否顺序
        if(maxValue != digitSet.size() || digitCount != maxValue ) {
            throw new RuntimeException("Invalid sequence definition");
        }
        CodePattern codePattern = new CodePattern(rule, digitCount);
        cache.put(pattern, codePattern);

        return codePattern;
    }

    @Data
    @AllArgsConstructor
    public class CodePattern {
        private int[] rule;
        private int digitCount;
    }

}
