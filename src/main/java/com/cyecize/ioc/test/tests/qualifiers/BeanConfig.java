package com.cyecize.ioc.test.tests.qualifiers;

import com.cyecize.ioc.annotations.Bean;
import com.cyecize.ioc.annotations.NamedInstance;
import com.cyecize.ioc.annotations.Service;

@Service
public class BeanConfig {

    @Bean
    @NamedInstance("COMMON_NAME")
    public CommonBean commonBean() {
        return new CommonBean();
    }
}
