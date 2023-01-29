package com.study.java_study.aop;

import com.study.java_study.JavaStudyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = JavaStudyApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

    @Resource
    private ImportService service;

    @Test
    public void testSpiralOrder() {
        service.importInfo(new ImportInfo("id", "name"));
    }


}
