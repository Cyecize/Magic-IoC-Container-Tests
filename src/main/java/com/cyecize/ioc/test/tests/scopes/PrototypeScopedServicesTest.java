package com.cyecize.ioc.test.tests.scopes;

import com.cyecize.ioc.annotations.Qualifier;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.services.DependencyContainer;
import com.cyecize.ioc.test.ApplicationEntryPoint;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;
import com.cyecize.ioc.test.tests.scopes.beans.PrototypeScopeBean;
import com.cyecize.ioc.test.tests.scopes.services.PrototypeScopedService;
import com.cyecize.ioc.test.tests.scopes.services.PrototypeScopedServiceImpl;

@Service
public class PrototypeScopedServicesTest implements Test {

    private final PrototypeScopedService prototypeScopedService1;

    private final PrototypeScopedService prototypeScopedService2;

    private final PrototypeScopeBean prototypeScopeBean;

    private final PrototypeScopeBean prototypeScopeBean_2;

    private final PrototypeScopeBean prototypeScopeBean2;

    public PrototypeScopedServicesTest(PrototypeScopedService prototypeScopedService1,
                                       PrototypeScopedService prototypeScopedService2,
                                       @Qualifier("bean_1") PrototypeScopeBean prototypeScopeBean,
                                       @Qualifier("bean_1") PrototypeScopeBean prototypeScopeBean_2,
                                       @Qualifier("bean_2") PrototypeScopeBean prototypeScopeBean2) {
        this.prototypeScopedService1 = prototypeScopedService1;
        this.prototypeScopedService2 = prototypeScopedService2;
        this.prototypeScopeBean = prototypeScopeBean;
        this.prototypeScopeBean_2 = prototypeScopeBean_2;
        this.prototypeScopeBean2 = prototypeScopeBean2;
    }

    @Override
    public void runTest() {
        final DependencyContainer dependencyContainer = ApplicationEntryPoint.dependencyContainer;
        final PrototypeScopedService prototypeScopedService3 = dependencyContainer.getService(PrototypeScopedService.class);

        Assert.equal(
                "Injected PROTOTYPE service should be concrete implementation, not proxy",
                PrototypeScopedServiceImpl.class,
                this.prototypeScopedService1.getClass(),
                "Invalid Injection!"
        );

        Assert.notEqual(
                "Requesting prototype service from DependencyContainer should return new instance",
                this.prototypeScopedService1.getIdentity(),
                prototypeScopedService3.getIdentity(),
                "Invalid service scope handling!"
        );

        Assert.notEqual(
                "Requesting multiple prototype services from the same type should inject different instances",
                this.prototypeScopedService1.getIdentity(),
                this.prototypeScopedService2.getIdentity(),
                "Invalid service scope handling!"
        );

        Assert.notEqual(
                "Requesting multiple prototype beans from the same type should inject different instances",
                this.prototypeScopeBean.getIdentity(),
                this.prototypeScopeBean_2.getIdentity(),
                "Invalid bean scope handling!"
        );

        Assert.notEqual(
                "Prototype scope beans with different qualifiers should work together",
                this.prototypeScopeBean.getClass(),
                this.prototypeScopeBean2.getClass(),
                "Invalid Injection!"
        );

        final PrototypeScopeBean beanOne = dependencyContainer.getService(PrototypeScopeBean.class, "bean_1");

        Assert.notEqual(
                "Prototype bean should give new instance when requested",
                this.prototypeScopeBean.getIdentity(),
                beanOne.getIdentity(),
                "Invalid scope handling!"
        );
    }
}
