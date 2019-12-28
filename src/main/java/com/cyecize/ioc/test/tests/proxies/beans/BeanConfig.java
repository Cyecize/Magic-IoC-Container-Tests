package com.cyecize.ioc.test.tests.proxies.beans;

import com.cyecize.ioc.annotations.Bean;
import com.cyecize.ioc.annotations.Scope;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.enums.ScopeType;

@Service
public class BeanConfig {

    @Bean
    @Scope(ScopeType.PROXY)
    public NonProxiedBean nonProxiedBean() {
        return new NonProxiedBean();
    }

    @Bean
    @Scope(ScopeType.PROXY)
    public ProxyBean proxyBean() {
        return new ProxyBeanImpl();
    }
}
