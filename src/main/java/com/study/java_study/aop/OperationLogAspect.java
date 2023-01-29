package com.study.java_study.aop;

import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@Aspect
public class OperationLogAspect {

    // Pointcut 标记这是一个切点
    @Pointcut("@annotation(com.study.java_study.aop.OperationLog)")
    public void opLog() {

    }

    // 定义线程池，异步记录日志
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    @Around(value = "opLog() && @annotation(operationLog)")
    public Object aroundMethod(ProceedingJoinPoint pjd, OperationLog operationLog) throws Throwable {
        Object result = null;
        String auditResult = "success";
        Throwable exception = null;
        try {
            result = pjd.proceed();
        } catch (Throwable throwable) {
            auditResult = "fail";
            exception = throwable;
        }

        // 获取方法传入对参数
        Object[] args = pjd.getArgs();
        if (args == null) {
            return result;
        }

        // doSomething 比如记录审计日志
        threadPoolExecutor.execute(() -> {
            MethodSignature methodSignature = (MethodSignature) pjd.getSignature();
            OperationLog annotation = methodSignature.getMethod().getAnnotation(OperationLog.class);
            Class<? extends Convert> convert = annotation.convert();
            try {
                Convert logConverter = convert.newInstance();
                var logDo = logConverter.convert(pjd.getArgs()[0]);
                System.out.println(logDo.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });


        if (exception != null) {
            throw exception;
        }

        return result;


    }

}
