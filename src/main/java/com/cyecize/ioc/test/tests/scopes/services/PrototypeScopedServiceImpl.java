package com.cyecize.ioc.test.tests.scopes.services;

import com.cyecize.ioc.annotations.PostConstruct;
import com.cyecize.ioc.annotations.Scope;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.enums.ScopeType;

@Service
@Scope(ScopeType.PROTOTYPE)
public class PrototypeScopedServiceImpl implements PrototypeScopedService {

    private static int id = 0;

    private int instanceId;

    public PrototypeScopedServiceImpl() {
        int a = 10;
    }

    @PostConstruct
    public void init() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
