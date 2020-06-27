package com.brower.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 启动Chrome浏览器示例代码
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:32
 */
public class TestChromeBrowser {
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
    public void testChrome() {
        //打开Chrome浏览器访问百度首页
        driver.get("https://www.baidu.com/");
    }

    @AfterClass
    public void afterClass() {
        //关闭打开的浏览器
        driver.quit();
    }
}
