package com.pageobject.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPageObject {

    /**
     * 因360影视登录页改版过大，影响脚本运行
     * 顾现采用365漂漂网作为演示案例
     *
     */
    public static final String URL = "http://manage.365pp.com/";
    WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        //设置系统变量，并设置chromedriver的路径为系统属性值
        System.setProperty("webdriver.chrome.driver","tool/chromedriver.exe");
        //实例ChromeDriver
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * 测试登录
     */
    @Test
    public void testLogin() {
        //实例化操作对象
        LoginMovies loginMovies = new LoginMovies(driver);
        loginMovies.login("your userName","your passWord","正在登录!请稍后...");
    }

    @AfterClass
    public void closedChrome() {
        driver.quit();
    }

}