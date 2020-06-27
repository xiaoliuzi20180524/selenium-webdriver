package com.testng.demo2;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @description 常用注解案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 13:50
 */
public class AnnotationsDemo {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite。。。。。。");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod。。。。。。");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass。。。。。。");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest。。。。。。");
    }

    @Test
    public void test1() {
        System.out.println("这是第一个测试。。。。。。");
        Assert.assertEquals(add(1, 1), 2);
    }

    @Test
    public void test2() {
        System.out.println("这是第二个测试。。。。。。");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest。。。。。。");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass。。。。。。");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod。。。。。。");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite。。。。。。");
    }

    /**
     * 两个数相加
     *
     * @param i
     * @param j
     * @return
     */
    public int add(int i, int j) {
        return i + j;
    }
}