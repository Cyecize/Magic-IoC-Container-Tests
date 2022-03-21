package com.cyecize.ioc.test.circulardeptest.deps;

import com.cyecize.ioc.test.circulardeptest.CircDepTestService;

@CircDepTestService
public class AccountServiceImpl implements AccountService {

    private final ProductService productService;

    public AccountServiceImpl(ProductService productService) {
        this.productService = productService;
    }
}
