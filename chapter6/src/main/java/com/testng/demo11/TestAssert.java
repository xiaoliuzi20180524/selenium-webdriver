package com.testng.demo11;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @description 硬断言演示案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:26
 */
public class TestAssert {
    @Test
    public void testAssert() throws Exception {
        Assert.assertEquals(4,2 * 2);
        Assert.assertEquals(5,1+9);
    }
}
