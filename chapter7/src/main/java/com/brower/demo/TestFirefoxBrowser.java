package com.brower.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description Firefox浏览器示例代码
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:36
 */
public class TestFirefoxBrowser {

    /**
     * 老版本Firefox浏览器,默认安装路径演示案例
     */
    //@Test
    public void testFirefox1() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/");
    }

    /**
     * 非默认安装路径演示案例
     */
    //@Test
    public void testFirefox2() {
        //指定Firefox浏览器安装路径
        System.setProperty("webdriver.firefox.bin", "E:/Program Files/Mozilla Firefox/firefox.exe");
        //实例Firefox
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.baidu.com/");
    }

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设置系统变量，并设置 geckodriver 的路径为系统属性值
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
        //导入Firefox浏览器安装路径
        System.setProperty("webdriver.firefox.bin", "E:/Program Files/Mozilla Firefox/firefox.exe");
        //将driver实例化为FirefoxDriver对象
        driver = new FirefoxDriver();
        //浏览器最大化
        driver.manage().window().maximize();
    }

    @Test
    public void testFirefox() {
        //打开Chrome浏览器访问百度首页
        driver.get("https://www.baidu.com/");
    }

    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
