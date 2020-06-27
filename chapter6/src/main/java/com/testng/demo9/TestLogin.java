package com.testng.demo9;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author rongrong
 * @version 1.0
 * @description 使用@DataProvider进行参数化测试
 * 场景：模拟用户登录测试用例
 * @date 2020/6/26 14:22
 */
public class TestLogin {
    @Test(dataProvider = "testlogin")
    public void testlogin(String username, String password) {
        System.out.println("用户名为：" + username + "\t" + "密码为：" + password);
    }

    @DataProvider(name = "testlogin")
    public Object[][] testlogin() {
        return new Object[][]{
                //用户名为空,密码不为空
                {"", "12346"},
                //用户名不为空,密码为空
                {"rongrong", ""},
                //用户名正确,密码不正确
                {"rongrong", "123654"},
                //用户名不正确,密码正确
                {"rong", "123456"},
                //用户名、密码正确
                {"rongrong", "123456"},
        };
    }
}
