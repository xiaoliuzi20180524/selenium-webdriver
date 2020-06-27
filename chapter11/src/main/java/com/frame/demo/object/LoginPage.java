package com.frame.demo.object;

import com.frame.demo.action.Action;
import org.testng.Assert;
public class LoginPage extends Action {
    public void login(String userName,String pwd,String expected) throws Exception {
        open();
        //因网页改版注释掉密码登录
        //click("密码登录");
        switchToFrame(0);
        sendKeys("输入用户名",userName);
        sendKeys("输入密码",pwd);
        click("点击登录");
        Thread.sleep(1000);
        String msg = getText("错误提示信息");
        Assert.assertEquals(msg,expected);
        quit();
    }
}