package com.cyecize.ioc.test.tests.scopes.beans;

public class PrototypeScopeBean1 implements PrototypeScopeBean {
    private static int id = 0;

    private int instanceId;


    public PrototypeScopeBean1() {
        this.instanceId = ++id;
    }

    public int getIdentity() {
        return this.instanceId;
    }
}
