package com.pageobject.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //定位 用户名输入框
    public static By userNameInput = By.name("username");
    //定位 密码输入框
    public static By passWordInput = By.name("password");
    //定位 登录按钮
    public static By loginBtn = By.id("loginBut");
    //定位 提示错误信息
    public static By errorMsg = By.id("stateSpan");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * 用户名输入操作
     *
     * @param userName
     */
    public void sendKeysUserName(String userName) {
        driver.findElement(userNameInput).clear();
        driver.findElement(userNameInput).sendKeys(userName);
    }

    /**
     * 密码输入操作
     *
     * @param passWord
     */
    public void sendKeysPassWord(String passWord) {
        driver.findElement(passWordInput).clear();
        driver.findElement(passWordInput).sendKeys(passWord);
    }
}