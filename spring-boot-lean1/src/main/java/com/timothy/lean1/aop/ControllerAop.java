package com.timothy.lean1.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.timothy.common.bean.TreeRecode;
import jdk.internal.org.objectweb.asm.Handle;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.omg.CORBA.LongHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author yutimothy
 * @Date 2021/1/11 23:11
 * @Version 1.0
 */
//@Aspect
//@Component
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    private static final ThreadLocal<TreeRecode> threadLocal;

    static {
        threadLocal = new ThreadLocal<>();
    }

    @Around("execution(* com.timothy.lean1.controller.*.*(..))")
    public Object testAop(ProceedingJoinPoint joinPoint) throws Throwable {
        return writeLog(joinPoint);
    }

    @Around("execution(* com.timothy.lean1.service.Impl.*.*(..))")
    public Object aopService(ProceedingJoinPoint joinPoint) throws Throwable {
        return writeLog(joinPoint);
    }


    private Object writeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();

        long start = System.currentTimeMillis();
//        logger.info("invoking start ,{},on time {},use time, {}ms", signature, start, 0);
        TreeRecode parentNode = threadLocal.get();
        if (Objects.isNull(parentNode)) {
            parentNode = new TreeRecode();
            parentNode.setParentNode(null);
            parentNode.setSignature(signature);
            threadLocal.set(parentNode);
        } else {
            TreeRecode childNode = new TreeRecode();
            parentNode.add(childNode);
            childNode.setSignature(signature);
            childNode.setParentNode(parentNode);
            threadLocal.set(childNode);
        }

        Object proceed = joinPoint.proceed(args);

        long end = System.currentTimeMillis();
        long useTime = end - start;
        TreeRecode childNode = threadLocal.get();
        childNode.setUseTime(useTime);
        if (!Objects.isNull(childNode.getParentNode())) {
            threadLocal.set(childNode.getParentNode());
        } else {
            logger.info(String.valueOf(childNode));
            threadLocal.set(null);
        }

//        logger.info("invoking end,{},on time {},use time, {}ms", signature, end, end - start);
        return proceed;
    }
}
