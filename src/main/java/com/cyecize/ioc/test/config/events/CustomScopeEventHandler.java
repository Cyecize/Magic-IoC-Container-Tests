package com.cyecize.ioc.test.config.events;

import com.cyecize.ioc.enums.ScopeType;
import com.cyecize.ioc.events.ServiceDetailsCreated;
import com.cyecize.ioc.models.ServiceDetails;
import com.cyecize.ioc.test.config.annotations.CustomProxyScope;

public class CustomScopeEventHandler implements ServiceDetailsCreated {
    @Override
    public void serviceDetailsCreated(ServiceDetails serviceDetails) {
        if (serviceDetails.getServiceType().isAnnotationPresent(CustomProxyScope.class)) {
            serviceDetails.setScopeType(ScopeType.PROXY);
        }
    }
}
