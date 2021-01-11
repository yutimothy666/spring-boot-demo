package com.timothy.lean1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author yutimothy
 * @Date 2021/1/11 23:11
 * @Version 1.0
 */
@Aspect
@Component
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    @Around("execution(* com.timothy.lean1.controller.*.*(..))")
    public Object testAop(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed(args);
        long end = System.currentTimeMillis();
        logger.info("invoking,{},{},use time, {}ms", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), end - start);
        return proceed;
    }
}
