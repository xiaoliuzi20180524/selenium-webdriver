package com.demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author rongrong
 * @version 1.0
 * @description
 * @date 2020/6/26 13:02
 */
public class TestHelloWorld {
    @Test
    public void testSayHello() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        Assert.assertEquals("Hello World", result);
    }
}
