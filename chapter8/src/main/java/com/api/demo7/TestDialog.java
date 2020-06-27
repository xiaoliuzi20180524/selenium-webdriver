package com.api.demo7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description 弹窗处理
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:40
 */
public class TestDialog {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * Alert弹窗处理
     */
    @Test
    public void testAlert() {
        driver.get("http://localhost:8080/popup.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("alert")).click();
        //获取alert对话框
        Alert alert = driver.switchTo().alert();
        //获取对话框文本
        String text = alert.getText();
        //打印警告对话框内容
        System.out.println(text);
        //alert对话框属于警告对话框，我们这里只能接受弹窗
        alert.accept();
    }


    /**
     * Confirm弹窗处理
     */
    @Test
    public void testConfirm() {
        driver.get("http://localhost:8080/popup.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("alert")).click();
        //获取alert对话框
        Alert alert = driver.switchTo().alert();
        //获取对话框文本
        String text = alert.getText();
        //打印警告对话框内容
        System.out.println(text);
        //alert对话框属于警告对话框，我们这里只能接受弹窗
        alert.accept();
    }

    /**
     * Prompt弹窗处理
     */
    @Test
    public void testPrompt() {
        driver.get("http://localhost:8080/popup.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.id("welcome")).click();
        //获取prompt对话框
        Alert alert = driver.switchTo().alert();
        //获取对话框的内容
        String text = alert.getText();
        //打印对话框的内容
        System.out.println(text);
        //在弹框内输入信息
        alert.sendKeys("软件测试君");
        //点击“确认”按钮，提交输入的内容
        alert.accept();
    }
}
