package com.cyecize.ioc.test.tests.collections;

import com.cyecize.ioc.annotations.Service;

@Service
public class Home3ImplDependsOnHome1 implements HomeService {

    private final Home1Impl home1;

    public Home3ImplDependsOnHome1(Home1Impl home1) {
        this.home1 = home1;
    }

    @Override
    public String getHomeName() {
        return "home3";
    }
}
