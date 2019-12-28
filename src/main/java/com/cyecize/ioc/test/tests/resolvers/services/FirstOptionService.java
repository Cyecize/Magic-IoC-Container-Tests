package com.cyecize.ioc.test.tests.resolvers.services;

import com.cyecize.ioc.annotations.NamedInstance;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.config.annotations.Resource;

@Service
@NamedInstance("first")
public class FirstOptionService implements OptionService {

    private final String option;

    public FirstOptionService(@Resource("opt1") String option) {
        this.option = option;
    }

    @Override
    public String getOption() {
        return this.option;
    }
}
