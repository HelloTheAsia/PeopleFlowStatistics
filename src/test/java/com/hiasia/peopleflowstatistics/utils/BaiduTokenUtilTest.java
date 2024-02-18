package com.hiasia.peopleflowstatistics.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class BaiduTokenUtilTest {

    @Test
    void name() throws Exception {
        String accessToken = BaiduTokenUtil.getAccessToken("rqGgw5no43etW5SvEL823Kl2", "rE97752UwklRHSyc7bYbGqmUtFMA7GIM");
        System.out.println(accessToken);
        Assertions.assertNotNull(accessToken);
    }
}