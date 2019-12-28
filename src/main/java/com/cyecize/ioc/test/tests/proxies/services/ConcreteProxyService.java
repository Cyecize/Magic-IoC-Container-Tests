package com.cyecize.ioc.test.tests.proxies.services;

import com.cyecize.ioc.annotations.PostConstruct;
import com.cyecize.ioc.annotations.Scope;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.enums.ScopeType;

@Service
@Scope(ScopeType.PROXY)
public class ConcreteProxyService {

    private static int id = 0;

    private int instanceId;

    @PostConstruct
    public void onInt() {
        this.instanceId = ++id;
    }


    public int getIdentity() {
        return this.instanceId;
    }
}
