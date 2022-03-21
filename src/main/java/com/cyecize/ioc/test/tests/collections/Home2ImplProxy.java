package com.cyecize.ioc.test.tests.collections;

import com.cyecize.ioc.annotations.Scope;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.enums.ScopeType;

@Service
@Scope(ScopeType.PROXY)
public class Home2ImplProxy implements HomeService {
    @Override
    public String getHomeName() {
        return "home2";
    }
}
