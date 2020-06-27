package com.testng.demo6;

import org.testng.annotations.Test;

/**
 * @description 异常测试示例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:13
 */
public class TestException {
    @Test(expectedExceptions = NullPointerException.class)
    public void testException() {
        throw new  NullPointerException();
    }
}
