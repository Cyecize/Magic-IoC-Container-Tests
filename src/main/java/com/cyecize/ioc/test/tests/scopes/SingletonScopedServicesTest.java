package com.cyecize.ioc.test.tests.scopes;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.services.DependencyContainer;
import com.cyecize.ioc.test.ApplicationEntryPoint;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;
import com.cyecize.ioc.test.tests.scopes.services.DefaultScopedService;
import com.cyecize.ioc.test.tests.scopes.services.DefaultScopedServiceImpl;

@Service
public class SingletonScopedServicesTest implements Test {

    private final DefaultScopedService defaultScopedService;

    public SingletonScopedServicesTest(DefaultScopedService defaultScopedService) {
        this.defaultScopedService = defaultScopedService;
    }

    @Override
    public void runTest() {
        final DependencyContainer dependencyContainer = ApplicationEntryPoint.dependencyContainer;

        Assert.equal(
                "Injected SINGLETON service should be concrete implementation, not proxy",
                DefaultScopedServiceImpl.class, this.defaultScopedService.getClass(),
                "Invalid Injection!"
        );

        Assert.equal(
                "Singleton service value should be as expected",
                1, this.defaultScopedService.getIdentity(),
                "Invalid value"
        );

        final DefaultScopedService defaultScopedService = dependencyContainer.getService(DefaultScopedService.class);

        Assert.equal(
                "Getting singleton from dependency container should return the same instance as in injection.",
                this.defaultScopedService.getIdentity(),
                defaultScopedService.getIdentity(),
                "Invalid Injection"
        );

        dependencyContainer.reload(DefaultScopedService.class);
        final DefaultScopedService reloadedScopedService = dependencyContainer.getService(DefaultScopedService.class);

        Assert.equal(
                "Reloaded singleton service should be concrete implementation, not proxy",
                DefaultScopedServiceImpl.class,
                reloadedScopedService.getClass(),
                "Invalid reload!"
        );

        Assert.equal(
                "Reloaded service should have +1 identity from the original injected one, original one should remain the same",
                this.defaultScopedService.getIdentity() + 1,
                reloadedScopedService.getIdentity(),
                "Invalid reload!"
        );
    }
}
