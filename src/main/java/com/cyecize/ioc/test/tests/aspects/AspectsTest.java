package com.cyecize.ioc.test.tests.aspects;

import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;

@Service
public class AspectsTest implements Test {

    private final EnrichedService enrichedService;

    public AspectsTest(EnrichedService enrichedService) {
        this.enrichedService = enrichedService;
    }

    @Override
    public void runTest() {
        Assert.equal(
                "Enriched service non enriched method",
                "realValue",
                this.enrichedService.getIdentification(),
                "Invalid service identification"
        );

        Assert.equal(
                "Enriched service enriched method",
                "enrichedValue",
                this.enrichedService.getIdentificationEnriched(),
                "Invalid service identification"
        );
    }
}
