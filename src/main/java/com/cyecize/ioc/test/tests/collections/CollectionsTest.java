package com.cyecize.ioc.test.tests.collections;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CollectionsTest implements Test {

    private final Collection<HomeService> homeServicesCol;

    private final List<HomeService> homeServicesList;

    private final Set<HomeService> homeServicesSet;

    public CollectionsTest(Collection<HomeService> homeServicesCol,
                           List<HomeService> homeServicesList,
                           Set<HomeService> homeServicesSet) {
        this.homeServicesCol = homeServicesCol;
        this.homeServicesList = homeServicesList;
        this.homeServicesSet = homeServicesSet;
    }

    @Override
    public void runTest() {
        Assert.notNull("Home Service collection", this.homeServicesCol, "Expecting collection to have value");
        Assert.notNull("Home Service list", this.homeServicesList, "Expecting collection to have value");
        Assert.notNull("Home Service set", this.homeServicesSet, "Expecting collection to have value");

        Assert.that(
                "Collections have same values",
                this.homeServicesCol.size() == this.homeServicesList.size()
                        && this.homeServicesSet.size() == this.homeServicesCol.size(),
                "The collections have different sizes"
        );

        final List<String> expectedResults = List.of("home2", "home1", "home5", "home3", "home4");

        final List<String> collectionResults = this.homeServicesCol.stream()
                .map(HomeService::getHomeName)
                .collect(Collectors.toList());

        Assert.equal("Collection values equal", expectedResults, collectionResults, "Invalid dependencies injected!");

        final List<String> listResults = this.homeServicesList.stream()
                .map(HomeService::getHomeName)
                .collect(Collectors.toList());

        Assert.equal("List values equal", expectedResults, listResults, "Invalid dependencies injected!");

        final List<String> setValues = this.homeServicesSet.stream()
                .map(HomeService::getHomeName)
                .collect(Collectors.toList());

        Assert.equal("Set values equal", expectedResults, setValues, "Invalid dependencies injected!");
    }
}
