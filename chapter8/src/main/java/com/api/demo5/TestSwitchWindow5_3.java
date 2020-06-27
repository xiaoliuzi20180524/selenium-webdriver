package com.api.demo5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description 多个窗口切换操作案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:29
 */
public class TestSwitchWindow5_3 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSwitchWindow() {
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //窗口最大化
        driver.manage().window().maximize();
        //设置全局等待30秒
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //百度搜索框输入淘宝
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("淘宝");
        //点击百度一下
        driver.findElement(By.id("su")).click();
        //在百搜索结果中，选择“淘宝网 - 淘！我喜欢” 进入淘宝首页
        driver.findElement(By.linkText("淘宝网 - 淘！我喜欢")).click();
        // 获取当前页面句柄即老窗口句柄
        String oldHandle = driver.getWindowHandle();
        //获取当前窗口句柄组合
        Set<String> handles = driver.getWindowHandles();
        for (String s : handles) {
            //如果不是新窗口
            if (!oldHandle.equals(s)) {
                driver.switchTo().window(s);
            }else {
                driver.close();
            }
        }
        //点击登录
        driver.findElement(By.linkText("登录")).click();
        // 获取当前页面句柄即老窗口句柄
        oldHandle = driver.getWindowHandle();
        //获取当前窗口句柄组合
        handles = driver.getWindowHandles();
        for (String s : handles) {
            //如果不是新窗口
            if (!oldHandle.equals(s)) {
                driver.switchTo().window(s);
            }else {
                driver.close();
            }
        }
        //输出新窗口页面标题
        System.out.println(driver.getTitle());
        driver.findElement(By.linkText("密码登录")).click();
        //此处用户名和密码的dom结构会变，此处请自行修改定位
        driver.findElement(By.cssSelector("#fm-login-id")).sendKeys("your userName");
        driver.findElement(By.cssSelector("#fm-login-password")).sendKeys("'your password");
        driver.findElement(By.cssSelector(".password-login")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}