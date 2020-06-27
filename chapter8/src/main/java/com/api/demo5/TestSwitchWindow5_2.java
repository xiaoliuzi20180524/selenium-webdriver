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
 * @description 两个窗口切换操作案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 22:29
 */
public class TestSwitchWindow5_2 {
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
        //百度搜索框输入Refain 博客园
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("Refain 博客园");
        //点击百度一下
        driver.findElement(By.id("su")).click();
        //在百搜索结果中，选择Refain - 博客园 进入博客园页面
        //我的博客名改了Refain - 博客园,因此此处超链接为 久曲健 - 博客园
        driver.findElement(By.linkText("久曲健 - 博客园")).click();
        //获取当前窗口句柄组合
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
            //获得页面源代码
            String pageSource = driver.getPageSource();
            //如果当前页面源代码包含selenium Java中常见等待的几种形式，可能当前也页面不存在这篇文章了，此处可写成列表存在的一篇文章标题即可
            if (pageSource.equals("Selenium+java - Edge浏览器启动 - 久曲健 - 博客园")) {
                break;
            }
        }
        //点击博客园中第一篇文章
        driver.findElement(By.cssSelector(".forFlow .day:nth-of-type(1) .postTitle2")).click();
        //输出新窗口页面标题
        System.out.println(driver.getTitle());
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}