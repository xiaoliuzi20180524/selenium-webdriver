package com.api.demo9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/**
 * @description  下拉框处理
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:47
 */
public class TestSelectDemo {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSelectDemo() {
        //打开测试页面
        driver.get("http://localhost:8080/SelectDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //获取select元素对象
        WebElement element = driver.findElement(By.id("select"));
        Select select = new Select(element);
        //根据索引选择，选择第1个英雄:李白
        select.selectByIndex(0);
        //根据value值选择第4个英雄:凯
        select.selectByValue("4");
        //根据文本值选择第2个英雄:韩信
        select.selectByVisibleText("韩信");
        //判断是否支持多选
        System.out.println(select.isMultiple());
        //获取选中项文本
        String text = select.getFirstSelectedOption().getText();
        //打印选中项文本
        System.out.println(text);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}