package com.cyecize.ioc.test.tests.customannotations;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;

@Service
public class CustomAnnotationsTest implements Test {

    private final CustomAnnotatedHomeService customAnnotatedHomeService;

    public CustomAnnotationsTest(CustomAnnotatedHomeService customAnnotatedHomeService) {
        this.customAnnotatedHomeService = customAnnotatedHomeService;
    }

    @Override
    public void runTest() {
        Assert.notNull(
                "Custom annotated service should not be null",
                this.customAnnotatedHomeService,
                "Expecting service to be injected"
        );

        Assert.equal(
                "Custom annotated service value",
                "customAnnotatedHomeService1",
                this.customAnnotatedHomeService.getIdentification(),
                "Invalid service value"
        );

        Assert.equal(
                "Custom annotated service post construct annotation",
                "customPostConstruct",
                this.customAnnotatedHomeService.getPostConstructValue(),
                "Post construct was not executed properly"
        );
    }
}
