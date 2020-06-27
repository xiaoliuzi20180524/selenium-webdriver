package com.api.demo16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description 富文本操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 9:37
 */
public class TestRichText {
    WebDriver driver;

    /**
     * https://ueditor.baidu.com/website/onlinedemo.html
     * 为https协议如有安全提示，改为http://ueditor.baidu.com/website/onlinedemo.html访问
     */

    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 通过键盘事件实现输入操作
     */
    @Test
    public void testByActions() {
        driver.get("http://ueditor.baidu.com/website/onlinedemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions actions = new Actions(driver);
        //鼠标通过tab要先移到富文本框中
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("欢迎关注公众号：软件测试君").perform();
    }

    @Test
    public void testBySwitchIframe() {
        driver.get("http://ueditor.baidu.com/website/onlinedemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //进入富文本编辑器
        driver.switchTo().frame("ueditor_0");
        //输入文字
        driver.findElement(By.className("view")).sendKeys("欢迎关注公众号：软件测试君");
        //选中全部
        driver.findElement(By.className("view")).sendKeys(Keys.LEFT_CONTROL + "a");
        //跳出富文本编辑器
        driver.switchTo().defaultContent();
        //加粗操作
        driver.findElement(By.cssSelector(".edui-for-bold .edui-icon")).click();
    }

    /**
     * 通过执行js实现输入操作
     */
    @Test
    public void testByJs() {
        driver.get("http://ueditor.baidu.com/website/onlinedemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        String content = "欢迎关注公众号：软件测试君";
        //ueditor_0为所在iframe的id
        String js = "document.getElementById('ueditor_0').contentDocument.write('" + content + "');";
        ((JavascriptExecutor) driver).executeScript(js);
    }

}
