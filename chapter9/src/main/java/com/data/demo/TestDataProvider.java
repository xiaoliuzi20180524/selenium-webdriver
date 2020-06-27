package com.data.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/**
 * @description 利用DataProvider做数据驱动测试
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 13:22
 */
public class TestDataProvider {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.baidu.com/");
    }

    @Test(dataProvider = "keyWord")
    public void testDataProvider(String keyWord) {
        //在百度搜索框中输入搜索关键字
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys(keyWord);
        //点击百度一下
        driver.findElement(By.id("su")).click();
        //程序等待3秒,等待搜索结果
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //验证搜索结果的页面标题是否为关键字+_百度搜索
        Assert.assertEquals(driver.getTitle(),keyWord+"_百度搜索");
    }

    @DataProvider(name = "keyWord")
    public static Object[][] keyWord() {
        return new Object[][]{
                {"refain 博客园"},
                {"公众号 软件测试君"},
                {"qq群 721256703"}
        };
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}