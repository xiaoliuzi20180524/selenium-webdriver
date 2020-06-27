package com.testng.demo5;

import org.testng.annotations.Test;

/**
 * @description 分组测试示例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:10
 */
public class TestGroup {
    @Test(groups = "group1")
    public void test1() {
        System.out.println("我是第1组同学！");
    }

    @Test(groups = "group2")
    public void test2() {
        System.out.println("我是第2组同学！");
    }

    @Test(groups = "group1")
    public void test3() {
        System.out.println("我是第1组同学！");
    }

    @Test(groups = "group3")
    public void test4() {
        System.out.println("我是第3组同学！");
    }

    @Test(groups = "group2")
    public void test6() {
        System.out.println("我是第2组同学！");
    }

    @Test(groups = "group1")
    public void test5() {
        System.out.println("我是第1组同学！");
    }
}
