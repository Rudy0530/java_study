package com.study.java_study.aop;

import java.lang.annotation.*;

@Documented
// 保证注解中运行时也能保住功能
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OperationLog {

    String moduleId() default "";

    Class<? extends Convert> convert();
}
