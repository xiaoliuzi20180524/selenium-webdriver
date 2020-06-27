package com.api.demo11;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description  调用JavaScript操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:58
 */
public class TestJavaScript {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
    }

    /**
     * 场景1：打开百度首页,并弹窗提示hellow,world!,关闭弹窗,控制台输出弹窗文本hellow,world!
     */
    @Test
    public void testJavaScript() {
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("alert('hellow,world!')");
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(text);
        alert.accept();
    }

    @Test
    public void testChangeColor() {
        WebElement element = driver.findElement(By.id("su"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("document.getElementById('su').setAttribute('value', 'MyLove');",element);
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}