package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class TimeTraceAspect {

    private final Logger log = LoggerFactory.getLogger(TimeTraceAspect.class);

    @Around("execution(* com.example.demo..*(..)) && !target(com.example.demo.AppConfig)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{}: START", joinPoint.toString());
        long start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            log.info("{}: END, TIME: {}ms", joinPoint, end - start);
        }
    }
}
