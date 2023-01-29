package com.study.java_study.aop;

public class ImportOpLogConvert implements Convert<ImportInfo> {
    @Override
    public OperateLogDo convert(ImportInfo o) {
        return new OperateLogDo(o.getId(), o.getName());
    }
}
