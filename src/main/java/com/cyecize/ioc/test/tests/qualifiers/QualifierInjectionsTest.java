package com.cyecize.ioc.test.tests.qualifiers;

import com.cyecize.ioc.annotations.Nullable;
import com.cyecize.ioc.annotations.Qualifier;
import com.cyecize.ioc.annotations.Service;
import com.cyecize.ioc.test.asserts.Assert;
import com.cyecize.ioc.test.contracts.Test;

@Service
public class QualifierInjectionsTest implements Test {

    private final CommonBean qualifierCommonBean;

    private final CommonService qualifiedCommonService;

    private final CommonBean wrongQualifiedCommonBean;

    private final CommonService wrongQualifiedCommonService;

    private final CommonBean nonQualifierCommonBean;

    private final CommonService nonQualifierCommonService;

    public QualifierInjectionsTest(@Nullable @Qualifier("COMMON_NAME") CommonBean qualifierCommonBean,
                                   @Nullable @Qualifier("COMMON_NAME") CommonService commonService,
                                   @Nullable @Qualifier("wrong") CommonBean wrongQualifiedCommonBean,
                                   @Nullable @Qualifier("wrong_g") CommonService wrongQualifiedCommonService,
                                   @Nullable CommonBean nonQualifierCommonBean,
                                   @Nullable CommonService nonQualifierCommonService) {

        this.qualifierCommonBean = qualifierCommonBean;
        this.qualifiedCommonService = commonService;
        this.wrongQualifiedCommonBean = wrongQualifiedCommonBean;
        this.wrongQualifiedCommonService = wrongQualifiedCommonService;
        this.nonQualifierCommonBean = nonQualifierCommonBean;
        this.nonQualifierCommonService = nonQualifierCommonService;
    }

    @Override
    public void runTest() {
        Assert.notNull("Inject with common name qualifier not null", qualifierCommonBean, "Invalid Injection!");
        Assert.notNull("Inject with common name qualifier not null", qualifiedCommonService, "Invalid Injection!");

        Assert.isNull("Inject with invalid qualifier null", wrongQualifiedCommonBean, "Invalid Injection!");
        Assert.isNull("Inject with invalid qualifier null", wrongQualifiedCommonService, "Invalid Injection!");

        Assert.notNull("Inject named instance without qualifier not null", nonQualifierCommonBean, "Invalid Injection!");
        Assert.notNull("Inject named instance without qualifier not null", nonQualifierCommonService, "Invalid Injection!");
    }
}
