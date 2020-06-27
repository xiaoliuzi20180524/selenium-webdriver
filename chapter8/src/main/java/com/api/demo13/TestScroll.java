package com.api.demo13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 滚动条操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 8:46
 */
public class TestScroll {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();

    }


    /**
     * 滚动条操作案例
     *
     * @throws Exception
     */
    @Test
    public void testScroll() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://www.cnblogs.com/longronglang");
        Thread.sleep(1000);
        //获取第三篇文章列表元素
        WebElement element = driver.findElement(By.cssSelector(".forFlow .day:nth-of-type(2) .postTitle2"));
        Thread.sleep(2000);
        //将页面滚动条拖到底部
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        //将滚动条滚动至第三篇文章列表位置
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(2000);
        //将滚动条滚动到顶部
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",element);
        Thread.sleep(2000);
        //将滚动条滚动到指定位置
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(200,1000)");
    }
}
