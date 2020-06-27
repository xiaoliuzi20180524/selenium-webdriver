package com.pagefactory.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(HomePage.driver(), this);
    }

    //定位 用户名输入框
    @FindBy(how = How.NAME, using = "username")//第一种写法
    @CacheLookup
    private WebElement userName;
    //定位 密码输入框
    @FindBy(name = "password")//第二种写法
    @CacheLookup
    private WebElement passWord;
    //定位 登录按钮
    @FindBy(id = "loginBut")
    @CacheLookup
    private WebElement loginBtn;
    //定位 提示错误信息
    @FindBy(id = "stateSpan")
    @CacheLookup
    private WebElement errorMsg;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassWord() {
        return passWord;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    /**
     * 用户名输入操作
     *
     * @param userName
     */
    public void sendKeysUserName(String userName) {
        getUserName().clear();
        getUserName().sendKeys(userName);
    }

    /**
     * 密码输入操作
     *
     * @param passWord
     */
    public void sendKeysPassWord(String passWord) {
        getPassWord().clear();
        getPassWord().sendKeys(passWord);
    }
}