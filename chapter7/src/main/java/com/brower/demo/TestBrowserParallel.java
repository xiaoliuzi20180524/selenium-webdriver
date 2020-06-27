package com.brower.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description 模拟多个浏览器并行测试
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 18:41
 */
public class TestBrowserParallel {
    WebDriver driver;

    @Parameters("type")
    @BeforeClass
    public void beforeClass(String type) {
        if(type.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(type.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else {
            System.setProperty("webdriver.gecko.driver","driver/geckodriver.exe");
            System.setProperty("webdriver.firefox.bin","E:/Program Files/Mozilla Firefox/firefox.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(120,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //打开百度首页
        driver.get("https://www.baidu.com/");
    }

    @Test
    public void testBrowserParallel() {
        //在搜索框中输入"Refain 博客园"
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("Refain 博客园");
        //单击百度一下按钮
        driver.findElement(By.id("su")).click();
        //等待3秒，等待页面显示完全
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印页面标题
        System.out.println( driver.getTitle());

    }

    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
