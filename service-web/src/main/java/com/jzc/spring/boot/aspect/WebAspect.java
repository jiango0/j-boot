package com.jzc.spring.boot.aspect;

import groovy.util.logging.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class WebAspect {

    @Pointcut("execution(* com.jzc.spring.boot.*.controller.*.*(..)) && @annotation(com.jzc.spring.boot.aspect.Web)")
    public void pointcut() {
    }

    @Around(value = "pointcut() && @annotation(web)")
    public Object around(ProceedingJoinPoint joinPoint, Web web) throws Throwable {

        Object[] args = joinPoint.getArgs();

        for (int i=0; i<args.length; i++) {
            System.out.println("i: " + i + "_" + args[i]);
        }

        return joinPoint.proceed();
    }




    }
