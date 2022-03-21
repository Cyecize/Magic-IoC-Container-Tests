package com.cyecize.ioc.test.tests.collections;

import com.cyecize.ioc.annotations.Bean;
import com.cyecize.ioc.annotations.Service;

@Service
public class Home1Impl implements HomeService {

    @Override
    public String getHomeName() {
        return "home1";
    }

    @Bean
    public HomeService home5Bean() {
        return new Home5Bean();
    }
}
