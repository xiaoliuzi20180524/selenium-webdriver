package com.api.demo12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * @description 上传操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 0:05
 */
public class TestUpload {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver=new ChromeDriver();

    }

    /**
     * 普通上传
     */
    @Test
    public void testUpload() {
        driver.get("http://localhost:8080/upload.html");
        driver.manage().window().maximize();
        //其实质就是sendKeys输入路径
        driver.findElement(By.id("upload")).sendKeys("D:\\data.csv");
    }

    /**
     * 通过Robot对象上传文件
     * @throws AWTException
     */
    @Test
    public void testUploadByRobot() throws AWTException {
        driver.get("http://localhost:8080/upload.html");
        driver.manage().window().maximize();
        //选择文件
        driver.findElement(By.id("upload")).click();
        //复制剪切板
        setClipboardData("D:\\data.csv");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(100);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /**
     * 复制剪切板操作
     *
     * @param data
     */
    public void setClipboardData(String data) {
        StringSelection stringSelection = new StringSelection(data);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
    }

    /**
     * 借助AutoIt完成上传文件操作
     * 如书中方法不好用，请参考我这篇文章：https://www.cnblogs.com/longronglang/p/13197076.html
     */
    @Test
    public void testUploadByAutoIt() {
        driver.get("http://localhost:8080/upload.html");
        driver.manage().window().maximize();
        //选择文件
        driver.findElement(By.id("upload")).click();
        try {
            Runtime.getRuntime().exec("upload.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}
