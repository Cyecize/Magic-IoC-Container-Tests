package com.cyecize.ioc.test.circulardeptest.deps;

import com.cyecize.ioc.test.circulardeptest.CircDepTestService;

@CircDepTestService
public class CategoryServiceImpl implements CategoryService {

    private final AccountService accountService;

    public CategoryServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }
}
