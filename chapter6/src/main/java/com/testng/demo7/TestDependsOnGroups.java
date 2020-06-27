package com.testng.demo7;

import org.testng.annotations.Test;

/**
 * @description 依赖测试示例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:17
 */
public class TestDependsOnGroups {
    // test1 执行之前会先执行 test2， test3
    @Test(dependsOnMethods = {"test2", "test3"})
    public void test1() {
        System.out.println("test1执行了");
    }

    @Test
    public void test2() {
        System.out.println("test2执行了");
    }

    @Test
    public void test3() {
        System.out.println("test3执行了");
    }
}
