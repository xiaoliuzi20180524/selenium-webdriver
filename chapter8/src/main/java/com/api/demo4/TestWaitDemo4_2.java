package com.api.demo4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * @description 强制等待案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 22:29
 */
public class TestWaitDemo4_2 {

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testByThread() {
        //打开测试页面
        driver.get("http://localhost:8080/wait.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("wait")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获得div块级元素
        WebElement element = driver.findElement(By.id("green_box"));
        //获取该元素css样式中background-color属性值
        String cssValue = element.getCssValue("background-color");
        //输出属性值
        System.out.println("cssValue: "+cssValue);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}