package com.cyecize.ioc.test.asserts;

import java.util.List;

public class Assert {

    public static void that(String testing, boolean expression, String msg) {
        if (!expression) {
            throw new AssertionError(String.format("Failed: %s \n%s", testing, msg));
        }

        System.out.println("    Passed: " + testing);
    }

    public static void equal(String testing, Object o1, Object o2, String msg) {
        boolean equal = o1.equals(o2);

        if (!equal) {
            msg += String.format("Expected: '%s', got: '%s'", o1, o2);
        }

        Assert.that(testing, equal, msg);
    }

    public static <T> void equal(String testing, List<T> col1, List<T> col2, String msg) {
        boolean eq = col1.containsAll(col2) && col2.containsAll(col1);
        if (!eq) {
            msg += String.format("Expected collection (%s) to equal (%s).", col1, col2);
        }

        Assert.that(testing, eq, msg);
    }

    public static void notEqual(String testing, Object o1, Object o2, String msg) {
        boolean notEqual = !o1.equals(o2);

        if (!notEqual) {
            msg += String.format("Expected different value than: '%s'", o1);
        }

        Assert.that(testing, notEqual, msg);
    }

    public static void isNull(String testing, Object o, String msg) {
        Assert.that(testing, o == null, msg);
    }

    public static void notNull(String testing, Object o, String msg) {
        Assert.that(testing, o != null, msg);
    }
}
