package com.cyecize.ioc.test.tests.beans;

import com.cyecize.ioc.annotations.Autowired;
import com.cyecize.ioc.annotations.Nullable;
import com.cyecize.ioc.annotations.Qualifier;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;

@Service
public class BeanQualifierAndInjectionTest implements Test {

    private final SomeInterfaceBean randomBean;

    private final SomeInterfaceBean beanImpl1;

    private final SomeInterfaceBean beanImpl2;

    @Autowired
    @Qualifier("bean_1")
    private SomeInterfaceBean beanImpl1Field;

    @Autowired
    @Qualifier("invalid_qualifier")
    @Nullable
    private SomeInterfaceBean invalidBean;

    public BeanQualifierAndInjectionTest(SomeInterfaceBean randomBean,
                                         @Qualifier("bean_1") SomeInterfaceBean beanImpl1,
                                         @Qualifier("bean_2") SomeInterfaceBean beanImpl2) {
        this.randomBean = randomBean;
        this.beanImpl1 = beanImpl1;
        this.beanImpl2 = beanImpl2;
    }

    @Override
    public void runTest() {
        Assert.notNull("Bean without qualifier should not be null", this.randomBean, "Invalid Injection");

        Assert.equal("Should get value from bean_1", "impl1 bean", beanImpl1.getVal(), "Invalid Injection!");
        Assert.equal("Should get value from bean_2", "impl2 bean", beanImpl2.getVal(), "Invalid Injection!");

        Assert.equal(
                "Autowired field with same qualifier should match constructor param",
                this.beanImpl1.getVal(), this.beanImpl1Field.getVal(),
                "Invalid Injection!"
        );

        Assert.isNull("Invalid qualifier should inject null field dependency", invalidBean, "Invalid Injection");
    }
}
