package com.study.java_study.aop;

import org.springframework.stereotype.Component;

@Component
public class ImportService {

    @OperationLog(moduleId = "test", convert = ImportOpLogConvert.class)
    public void importInfo(ImportInfo info) {

    }
}
