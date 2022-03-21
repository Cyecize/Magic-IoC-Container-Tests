package com.cyecize.ioc.test.circulardeptest.deps;

import com.cyecize.ioc.test.circulardeptest.CircDepTestService;

@CircDepTestService
public class ProductServiceImpl implements ProductService {

    private final CategoryService categoryService;

    public ProductServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
