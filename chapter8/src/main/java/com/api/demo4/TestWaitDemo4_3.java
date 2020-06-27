package com.api.demo4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description 页面等待
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 22:29
 */
public class TestWaitDemo4_3 {

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testByPageLoad() {
        //打开测试页面
        driver.get("http://localhost:8080/wait.html");
        //设置等待时间为3秒，如果3秒页面没有全部加载出来，就会报错，如果小于3秒就全部加载出来了，剩下的时间将不再等待，继续下一步操作
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}