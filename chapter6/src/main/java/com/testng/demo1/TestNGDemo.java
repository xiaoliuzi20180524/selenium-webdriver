package com.testng.demo1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * @description 入门案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 13:31
 */
public class TestNGDemo {

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass");
    }

    @Test
    public void test() {
        System.out.println("This is TestNG testCase");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is afterClass");
    }
}