package com.testng.demo11;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @description 软断言演示案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:27
 */
public class TestSoftAssert {
    @Test
    public void testSoftAssert(){
        System.out.println("脚本执行开始");
        //实例化SoftAssert
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(5,6,"我俩不是一样大");
        System.out.println("脚本执行结束");
        System.out.println("我是观望，到这会不会继续执行呢");
        //这个必须放到最后，没什么可说的
        assertion.assertAll();
    }
}
