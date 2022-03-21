package com.cyecize.ioc.test;

import com.cyecize.ioc.MagicInjector;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.annotations.StartUp;
import com.cyecize.ioc.config.MagicConfiguration;
import com.cyecize.ioc.exceptions.CircularDependencyException;
import com.cyecize.ioc.models.ServiceDetails;
import com.cyecize.ioc.services.DependencyContainer;
import com.cyecize.ioc.test.circulardeptest.CircDepTestService;
import com.cyecize.ioc.test.config.annotations.CustomBeanAnnotation;
import com.cyecize.ioc.test.config.annotations.CustomServiceAnnotation;
import com.cyecize.ioc.test.config.events.CustomScopeEventHandler;
import com.cyecize.ioc.test.config.producers.StringConfigProducer;
import com.cyecize.ioc.test.config.producers.StringConfigProducer2;
import com.cyecize.ioc.test.contracts.Test;

@Service
public class ApplicationEntryPoint {

    public static DependencyContainer dependencyContainer;

    public static void main(String[] args) {
        MagicConfiguration config = new MagicConfiguration()
                .instantiations()
                .addDependencyResolver(new StringConfigProducer())
                .addDependencyResolver(new StringConfigProducer2())
                .and()
                .scanning()
                .addServiceDetailsCreatedCallback(new CustomScopeEventHandler())
                .addCustomServiceAnnotation(CustomServiceAnnotation.class)
                .addCustomBeanAnnotation(CustomBeanAnnotation.class)
                .and();

        MagicInjector.run(ApplicationEntryPoint.class, config);
        runCircularDependencyTest(config);
    }

    @StartUp
    public void appStarted(DependencyContainer dependencyContainer) {
        ApplicationEntryPoint.dependencyContainer = dependencyContainer;
        System.out.println("Application Started");

        var tests = dependencyContainer.getImplementations(Test.class);
        for (ServiceDetails test : tests) {
            this.runTest(test);
        }
    }

    private void runTest(ServiceDetails serviceDetails) {
        final Test test = (Test) serviceDetails.getInstance();

        System.out.println("Running tests from: " + serviceDetails.getServiceType().getName());
        test.runTest();

        System.out.println("\n");
    }

    private static void runCircularDependencyTest(MagicConfiguration config) {
        System.out.println("Running Circular dependency test");

        config.scanning().addCustomServiceAnnotation(CircDepTestService.class);

        try {
            MagicInjector.run(ApplicationEntryPoint.class, config);
        } catch (CircularDependencyException ex) {
            System.out.println("Test passed successfully!!!");
            System.out.println(ex.getMessage());
        }
    }
}
