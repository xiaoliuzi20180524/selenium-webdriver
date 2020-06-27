package com.api.demo4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description 显示等待方法1
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 22:29
 */
public class TestWaitDemo4_5 {

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testByShowWaiting1() {
        //打开测试页面
        driver.get("http://localhost:8080/wait.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("wait")).click();
        /**
         *等待时间为3秒，WebDriverWait默认每500ms就调用一次ExpectedCondition
         直到定位到div，如果3秒内div显示出来，则继续下一步，
         * 如果超过3秒没有显示出来，那么
         则until()会抛出org.openqa.selenium.TimeoutExceptionn异常
         */
        WebDriverWait wait = new WebDriverWait(driver,3);
        //元素是否存在，如果超过设置时间检测不到则抛出异常。
        wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                //重写方法 
                return driver.findElement(By.id("green_box"));
            }
        });
        //获得div块级元素
        WebElement element = driver.findElement(By.id("green_box"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: " + cssValue);
    }

    @Test
    public void testByShowWaiting2() {
        //打开测试页面
        driver.get("http://localhost:8080/wait.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("wait")).click();
        /**
         *等待时间为3秒，WebDriverWait默认每500ms就调用一次ExpectedCondition
         直到定位到div，如果3秒内div显示出来，则继续下一步，
         * 如果超过3秒没有显示出来，那么
         则until()会抛出org.openqa.selenium.TimeoutExceptionn异常
         */
        WebDriverWait wait = new WebDriverWait(driver,3);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("green_box")));
        //获得div块级元素
        WebElement element = driver.findElement(By.id("green_box"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: " + cssValue);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}