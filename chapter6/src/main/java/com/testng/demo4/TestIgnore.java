package com.testng.demo4;

import org.testng.annotations.Test;

/**
 * @description 忽略测试代码示例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:08
 */
public class TestIgnore {
    /**
     * 默认情况下enable属性为true
     */
    @Test
    public void test1() {
        System.out.println("这条测试用例会被执行");
    }

    @Test(enabled = true)
    public void test2() {
        System.out.println("enabled = true时，这条测试用例会被执行");
    }

    @Test(enabled = false)
    public void test3() {
        System.out.println("这条测试用例将不会被执行");
    }
}
