package com.cyecize.ioc.test.tests.customannotations;

import com.cyecize.ioc.annotations.AliasFor;
import com.cyecize.ioc.annotations.PostConstruct;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@AliasFor(PostConstruct.class)
public @interface CustomPostConstruct {
}
