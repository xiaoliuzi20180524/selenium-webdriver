package com.brower.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 启动IE浏览器示例代码
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:33
 */
public class TestIEBrowser {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设定IE浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.ie.driver","driver/IEDriverServer.exe");
        //将driver实例化为InternetExplorerDriver对象
        driver = new InternetExplorerDriver();
        //浏览器最大化
        driver.manage().window().maximize();
    }

    @Test
    public void testIE() {
        //打开Chrome浏览器访问百度首页
        driver.get("https://www.baidu.com/");
    }

    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
