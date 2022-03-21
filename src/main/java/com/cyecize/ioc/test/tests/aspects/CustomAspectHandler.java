package com.cyecize.ioc.test.tests.aspects;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.handlers.MethodInvocationChain;
import com.cyecize.ioc.handlers.ServiceMethodAspectHandler;

import java.lang.reflect.Method;

@Service
public class CustomAspectHandler implements ServiceMethodAspectHandler<CustomAspectAnnotation> {
    @Override
    public Object proceed(CustomAspectAnnotation customAspectAnnotation,
                          Method method,
                          Object[] objects,
                          MethodInvocationChain methodInvocationChain) throws Exception {
        return customAspectAnnotation.value();
    }
}
