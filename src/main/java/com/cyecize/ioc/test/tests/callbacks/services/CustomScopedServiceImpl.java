package com.cyecize.ioc.test.tests.callbacks.services;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.config.annotations.CustomProxyScope;

@Service
@CustomProxyScope
public class CustomScopedServiceImpl implements CustomScopedService {
}
