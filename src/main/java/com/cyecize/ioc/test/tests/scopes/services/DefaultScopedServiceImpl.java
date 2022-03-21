package com.cyecize.ioc.test.tests.scopes.services;

import com.cyecize.ioc.annotations.PostConstruct;
import com.cyecize.ioc.annotations.Service;

@Service
public class DefaultScopedServiceImpl implements DefaultScopedService {

    private static int id = 0;

    private int instanceId;

    @PostConstruct
    public void init() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
