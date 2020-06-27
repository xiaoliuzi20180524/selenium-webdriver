package com.testng.demo10;

import org.testng.annotations.Test;

/**
 * @description 多线程测试，没有关联的用例可以使用多线程减少执行时间
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:23
 */
public class TestMultiThreading {
    @Test(invocationCount = 10,threadPoolSize = 4)
    public void testMultiThreading(){
        System.out.println("Thread id :"+Thread.currentThread().getId());
    }
}
