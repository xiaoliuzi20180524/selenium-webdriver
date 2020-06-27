package com.api.demo3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 键盘操作案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 22:19
 */
public class KeyWordDemo {

    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        //将driver实例化为ChromeDriver对象
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testKeyWordDemo() {
        driver.get("https://www.baidu.com/");
        //浏览器最大化
        driver.manage().window().maximize();
        //输入回车操作
        driver.findElement(By.id("kw")).sendKeys("Refain 博客园" + Keys.ENTER);
        pause(2);
        //退格键操作
        driver.findElement(By.id("kw")).sendKeys("" + Keys.BACK_SPACE);
        pause(2);
        //全选
        driver.findElement(By.id("kw")).sendKeys("" + Keys.LEFT_CONTROL + "a");
        pause(2);
        //剪切
        driver.findElement(By.id("kw")).sendKeys("" + Keys.LEFT_CONTROL + "x");
        pause(2);
        //复制
        driver.findElement(By.id("kw")).sendKeys("" + Keys.LEFT_CONTROL + "v");
        pause(2);
        //复制
        driver.findElement(By.id("kw")).sendKeys("" + Keys.LEFT_CONTROL + "v");
    }

    /**
     * 暂停方法
     *
     * @param i 秒
     */
    private void pause(int i) {
        try {
            Thread.sleep(1000 * i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
