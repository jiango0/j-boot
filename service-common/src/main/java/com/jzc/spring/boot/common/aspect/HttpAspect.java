package com.jzc.spring.boot.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {

    public static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut(value = "execution( * com.jzc.spring.boot.*.controller..*.*(..))")
    public void execute() {}

    @Before("execute()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("beforeAdvice ====> ");
    }

    @After("execute()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("afterAdvice ====> ");
    }

    @AfterReturning(pointcut = "execute()", returning = "object")
    public void afterReturnAdvice(Object object) {
        System.out.println("afterReturnAdvice ====> ");
    }

    @AfterThrowing(value = "execute()", throwing = "exception")
    public void afterThrowAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("afterThrowAdvice ====> ");
    }

    @Around("execute()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            System.out.println("aroundBeforeAdvice ====> ");
            return joinPoint.proceed();
        } finally {
            System.out.println("aroundAfterAdvice ====> ");
        }
    }

}
