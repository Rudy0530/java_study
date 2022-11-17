package com.study.java_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext runContext = SpringApplication.run(JavaStudyApplication.class, args);

        // 获取所有容器中的组件名称
        String []names = runContext.getBeanDefinitionNames();
        for(String name:names){
            System.out.println(name);
        }


    }

}
