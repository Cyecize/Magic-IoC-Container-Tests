package com.cyecize.ioc.test.tests.resolvers.services;

import com.cyecize.ioc.annotations.NamedInstance;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.config.annotations.Resource;

@Service
@NamedInstance("second")
public class SecondOptionService implements OptionService {

    private final String option;

    public SecondOptionService(@Resource("opt2") String option) {
        this.option = option;
    }

    @Override
    public String getOption() {
        return this.option;
    }
}
