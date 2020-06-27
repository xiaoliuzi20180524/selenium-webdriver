package com.api.demo10;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
/**
 * @description  cookie处理操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:47
 */
public class LoginWithCookie {
    
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();
        
    }

    @Test
    public void testLoginWithCookie() {
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        Cookie cookie=new Cookie("BAIDUID","你的账号cookie");
        driver.manage().addCookie(cookie);
        Cookie cookie1=new Cookie("BDUSS","你的账号cookie");
        driver.manage().addCookie(cookie1);
        driver.navigate().refresh();
    }

    @AfterClass
    public void afterClass() {
//        driver.quit();
    }

}