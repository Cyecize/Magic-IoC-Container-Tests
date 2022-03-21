package com.cyecize.ioc.test.tests.collections;

import com.cyecize.ioc.annotations.Bean;
import com.cyecize.ioc.annotations.Service;

@Service
public class BeanCfgForCollections {

    @Bean
    public HomeService homeService() {
        return new Home4Bean();
    }
}
