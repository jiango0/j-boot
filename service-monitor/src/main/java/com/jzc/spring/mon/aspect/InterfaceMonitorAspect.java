package com.jzc.spring.mon.aspect;

import com.jzc.spring.mon.entity.CollectData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;

@Aspect
@Component
public class InterfaceMonitorAspect {

    @Pointcut("execution(public * *(..)) " +
            "&& @annotation(com.jzc.spring.mon.annotation.Collect) " +
            "&& @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void init(){}

    @Around("init()")
    public Object pointcut(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RequestMapping requestMapping = signature.getMethod().getAnnotation(RequestMapping.class);
        String[] value = requestMapping.value();
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();

        if (CollectData.data.containsKey(value[0])) {
            CollectData.data.get(value[0]).add(end - start);
        } else {
            CollectData.data.put(value[0], Collections.synchronizedList(new ArrayList<Long>(){{
                add(end -start);
            }}));
        }

        return proceed;
    }

}
