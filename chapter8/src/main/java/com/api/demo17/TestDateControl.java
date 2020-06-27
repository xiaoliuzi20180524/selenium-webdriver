package com.api.demo17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 日期控件操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 9:46
 */
public class TestDateControl {
    
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 通过JS选择日期
     */
    @Test
    public void testByJs() {
        driver.get("https://huoche.cncn.com/train-%B4%F3%C1%AC-%C9%F2%D1%F4");
        driver.manage().window().maximize();
        JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
        //remove readonly attribute
        removeAttribute.executeScript("var setDate=document.getElementById(\"date\").removeAttribute('readonly');");
        //输入要输入日期
        driver.findElement(By.id("date")).clear();
        driver.findElement(By.id("date")).sendKeys("2019-08-31");
        //点击查询
        driver.findElement(By.id("searchBtn")).click();
        //获取输入后日期显示
        String value = driver.findElement(By.id("date")).getAttribute("value");
        //验证日期是否为选中的8月31日
        Assert.assertEquals(value,"2019-08-31");
    }

    /**
     * 通过Iframe选择日期
     */
    @Test
    public void testByIframe() {
        driver.get("https://huoche.cncn.com/train-%B4%F3%C1%AC-%C9%F2%D1%F4");
        driver.manage().window().maximize();
        //点击日历控件
        driver.findElement(By.id("date")).click();
        //iframe框
        WebElement iframe = driver.findElement(By.cssSelector("[src='about\\:blank']"));
        //进入日历控件中操作
        driver.switchTo().frame(iframe);
        //选择31号即月末
        driver.findElement(By.xpath("//tr/td[@onclick='day_Click(2020,6,30);']")).click();
        //跳出日历控件操作
        driver.switchTo().defaultContent();
        //点击查询
        driver.findElement(By.id("searchBtn")).click();
        //获取输入后日期显示
        String value = driver.findElement(By.id("date")).getAttribute("value");
        //验证日期是否为选中的8月31日
        Assert.assertEquals(value,"2020-06-30");

    }
}
