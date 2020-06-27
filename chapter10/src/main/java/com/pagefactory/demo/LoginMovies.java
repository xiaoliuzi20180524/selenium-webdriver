package com.pagefactory.demo;

import org.testng.Assert;

public class LoginMovies {
    /***
     * 登录过程
     * @param userName
     * @param pwd
     * @param expected
     */
    public void loginByPageFactory(String userName, String pwd, String expected) {
        HomePage homePage = new HomePage();
        //打开登录页
        homePage.open();
        //输入用户名
        homePage.loginPage().sendKeysUserName(userName);
        //输入密码
        homePage.loginPage().sendKeysPassWord(pwd);
        //点击登录
        homePage.loginPage().getLoginBtn().click();
        //获取提示语操作
        String msg = homePage.loginPage().getErrorMsg().getText();
        //验证输入手机号错误是否提示
        Assert.assertEquals(msg, expected);
        //关闭浏览器
        homePage.close();
    }
}