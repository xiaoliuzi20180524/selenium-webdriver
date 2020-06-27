package com.pageobject.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginMovies {
    WebDriver driver;

    public LoginMovies(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 登录操作
     *
     * @param userName
     * @param pwd
     * @param expected
     */
    public void login(String userName,String pwd,String expected) {
        LoginPage loginPage = new LoginPage(driver);
        //输入用户名
        loginPage.sendKeysUserName(userName);
        //输入密码
        loginPage.sendKeysPassWord(pwd);
        //点击登录
        driver.findElement(LoginPage.loginBtn).click();
        //获取提示语操作
        String msg = driver.findElement(LoginPage.errorMsg).getText();
        Assert.assertEquals(msg,expected);
    }
}