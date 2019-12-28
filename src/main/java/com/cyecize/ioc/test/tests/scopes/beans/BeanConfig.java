package com.cyecize.ioc.test.tests.scopes.beans;

import com.cyecize.ioc.annotations.Bean;
import com.cyecize.ioc.annotations.NamedInstance;
import com.cyecize.ioc.annotations.Scope;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.enums.ScopeType;

@Service
public class BeanConfig {

    @Bean
    @Scope(ScopeType.PROTOTYPE)
    @NamedInstance("bean_1")
    public PrototypeScopeBean proxyScopeBean() {
        return new PrototypeScopeBean1();
    }

    @Bean
    @Scope(ScopeType.PROTOTYPE)
    @NamedInstance("bean_2")
    public PrototypeScopeBean proxyScopeBean2() {
        return new PrototypeScopeBean2();
    }
}
