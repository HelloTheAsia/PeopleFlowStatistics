package com.hiasia.peopleflowstatistics.utils;

import org.junit.jupiter.api.Test;


class Base64UtilTest {

    @Test
    void name() {
        String s = Base64Util.image2Base64("https://chat.hiasia.asia:6789/image/202312291337818.png");
        System.out.println("data:image/jpeg;base64," + s);
    }
}
