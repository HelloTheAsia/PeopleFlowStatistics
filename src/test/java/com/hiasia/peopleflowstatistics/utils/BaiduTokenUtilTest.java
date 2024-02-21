package com.hiasia.peopleflowstatistics.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaiduTokenUtilTest {

    @Test
    void name() throws Exception {
        String accessToken = BaiduTokenUtil.getAccessToken("JBNvSN0R2NpEviHJOXoUIl91", "75TY1zp0EZ871UMp5n6nhpnLkXQ03hMb");
        System.out.println(accessToken);
        Assertions.assertNotNull(accessToken);
    }
}