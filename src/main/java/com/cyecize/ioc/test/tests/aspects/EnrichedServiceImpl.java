package com.cyecize.ioc.test.tests.aspects;

import com.cyecize.ioc.annotations.Service;

@Service
public class EnrichedServiceImpl implements EnrichedService {
    @Override
    public String getIdentification() {
        return "realValue";
    }

    @Override
    @CustomAspectAnnotation("enrichedValue")
    public String getIdentificationEnriched() {
        return "realValue";
    }
}
