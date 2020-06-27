package com.api.demo3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 鼠标操作案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 21:32
 */
public class TestkeyboardApi {

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        //将driver实例化为ChromeDriver对象
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 鼠标悬浮操作
     */
    @Test
    public void testMouseHover()  {
        driver.get("http://localhost:8080/mouse.html");
        //鼠标悬浮和离开
        WebElement element1 = driver.findElement(By.id("mouse1"));
        WebElement element2 = driver.findElement(By.id("mouse6"));
        Actions action=new Actions(driver);
        //moveToElement移动操作,即悬浮在某个元素的位置
        action.moveToElement(element1).pause(3000).moveToElement(element2).perform();
    }

    /**
     * 鼠标单击操作
     */
    @Test
    public void testMouseSingleClick()  {
        driver.get("http://localhost:8080/mouse.html");
        //单击操作
        WebElement element = driver.findElement(By.id("mouse2"));
        Actions action=new Actions(driver);
        //click 单击操作
        action.click(element).perform();
    }

    /**
     * 鼠标双击操作
     */
    @Test
    public void testMouseDoubleClick()  {
        driver.get("http://localhost:8080/mouse.html");
        //双击操作
        WebElement element = driver.findElement(By.id("mouse3"));
        Actions action=new Actions(driver);
        //doubleClick 双击操作
        action.doubleClick(element).perform();
    }

    /**
     * 鼠标移动操作
     */
    @Test
    public void testMouseMove()  {
        driver.get("http://localhost:8080/mouse.html");
        //移动操作
        WebElement element = driver.findElement(By.id("mouse4"));
        Actions action=new Actions(driver);
        //moveToElement 移动操作
        action.moveToElement(element).perform();
    }

    /**
     * 鼠标右击操作
     */
    @Test
    public void testMouseRightClick()  {
        driver.get("http://localhost:8080/mouse.html");
        //右击操作
        WebElement element = driver.findElement(By.id("mouse5"));
        Actions action=new Actions(driver);
        //contextClick 右击操作
        action.contextClick(element).perform();
    }

    /**
     * 按住和释放操作
     */
    @Test
    public void testPressAndRelease()  {
        driver.get("http://localhost:8080/mouse.html");
        //按住和释放操作
        WebElement element = driver.findElement(By.id("mouse"));
        Actions action=new Actions(driver);
        //clickAndHold 按住不放
        //release 释放操作
        action.clickAndHold(element).pause(3000).release(element).perform();
    }

    /**
     * 练习1鼠标拖拽操作
     */
    @Test
    public void testDrag1()  {
        driver.get("http://localhost:8080/drag.html");
        //鼠标拖拽操作
        WebElement element1 = driver.findElement(By.id("A"));
        WebElement element2 = driver.findElement(By.xpath("//ul[2]"));
        Actions action=new Actions(driver);
        //dragAndDrop 拖拽操作
        action.dragAndDrop(element1,element2).perform();
    }

    /**
     * 练习2鼠标拖拽操作
     */
    @Test
    public void testDrag2()  {
        driver.get("http://localhost:8080/drag.html");
        //鼠标拖拽操作
        WebElement element1 = driver.findElement(By.id("A"));
        WebElement element2 = driver.findElement(By.xpath("//ul[2]"));
        WebElement element3 = driver.findElement(By.xpath("//ul[3]"));
        Actions action=new Actions(driver);
        //clickAndHold 按住不放
        //moveToElement 移动操作
        action.clickAndHold(element1).pause(1000).moveToElement(element2).pause(1000).moveToElement(element3).release().perform();
    }

}
