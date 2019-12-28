package com.cyecize.ioc.test.tests.callbacks;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;
import com.cyecize.ioc.test.tests.callbacks.services.CustomScopedService;
import com.cyecize.ioc.test.tests.callbacks.services.CustomScopedServiceImpl;

@Service
public class OnServiceCreatedCallbackTest implements Test {

    private final CustomScopedService customScopedService;

    public OnServiceCreatedCallbackTest(CustomScopedService customScopedService) {
        this.customScopedService = customScopedService;
    }

    @Override
    public void runTest() {
        Assert.notEqual(
                "CustomScopeEventHandler should have made CustomScopedService to proxy scope",
                CustomScopedServiceImpl.class,
                this.customScopedService.getClass(),
                "Error invoking custom service created callback."
        );
    }
}
