package com.testng.demo3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 套件测试类示例代码1
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 13:55
 */
public class TestSuiteDemo1 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass");
    }

    @Test
    public void test() {
        System.out.println("This is TestSuiteDemo1 testCase");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is afterClass");
    }
}
