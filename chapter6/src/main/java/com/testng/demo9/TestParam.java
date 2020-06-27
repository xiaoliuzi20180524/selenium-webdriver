package com.testng.demo9;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @description 基于xml文件结合Parameters配置的参数化测试
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:20
 */
public class TestParam {
    @Parameters({"username", "password"})
    @Test
    public void testLogin(String username, String password) {
        System.out.println(username + "\t" + password);
    }
}
