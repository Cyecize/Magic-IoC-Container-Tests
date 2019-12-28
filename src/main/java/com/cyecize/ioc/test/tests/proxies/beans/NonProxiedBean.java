package com.cyecize.ioc.test.tests.proxies.beans;

public class NonProxiedBean {
    private static int id = 0;

    private int instanceId;

    public NonProxiedBean() {
        this.instanceId = ++id;
    }

    public int getIdentity() {
        return this.instanceId;
    }
}
