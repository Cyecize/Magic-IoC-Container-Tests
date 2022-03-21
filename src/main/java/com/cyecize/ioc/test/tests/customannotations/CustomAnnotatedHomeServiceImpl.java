package com.cyecize.ioc.test.tests.customannotations;

import com.cyecize.ioc.test.config.annotations.CustomServiceAnnotation;

@CustomServiceAnnotation
public class CustomAnnotatedHomeServiceImpl implements CustomAnnotatedHomeService {

    private String postConstructVal;

    @Override
    public String getIdentification() {
        return "customAnnotatedHomeService1";
    }

    @Override
    public String getPostConstructValue() {
        return this.postConstructVal;
    }

    @CustomPostConstruct
    void init() {
        this.postConstructVal = "customPostConstruct";
    }
}
