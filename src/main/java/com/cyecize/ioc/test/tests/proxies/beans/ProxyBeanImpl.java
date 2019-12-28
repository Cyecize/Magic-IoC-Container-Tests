package com.cyecize.ioc.test.tests.proxies.beans;

public class ProxyBeanImpl implements ProxyBean {

    private static int id = 0;

    private int instanceId;

    public ProxyBeanImpl() {
        this.instanceId = ++id;
    }

    @Override
    public int getIdentity() {
        return this.instanceId;
    }
}
