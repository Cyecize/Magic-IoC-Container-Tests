package com.cyecize.ioc.test.tests.qualifiers;

import com.cyecize.ioc.annotations.NamedInstance;
import com.cyecize.ioc.annotations.Service;

@Service
@NamedInstance("COMMON_NAME")
public class CommonServiceImpl implements CommonService {
    @Override
    public String getIdentity() {
        return "COMMON_SERVICE";
    }
}
