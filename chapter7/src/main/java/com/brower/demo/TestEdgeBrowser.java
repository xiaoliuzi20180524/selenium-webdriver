package com.brower.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

/**
 * @description 启动Edge浏览器示例代码
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 14:46
 */
public class TestEdgeBrowser {
    /**
     * 由于win10系统版本差异问题，如果参照书中的方法启动浏览器失败，
     * 可参考我的博客文章操作，地址：https://www.cnblogs.com/longronglang/p/13195660.html
     */
    @Test
    public void testEdge() {
        //书中代码
        //System.setProperty("webdriver.edge.driver","driver/MicrosoftWebDriver.exe");
        //最新操作系统
        System.setProperty("webdriver.edge.driver","driver/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        driver.quit();
    }
}
