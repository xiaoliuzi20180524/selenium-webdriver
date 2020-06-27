package com.pagefactory.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    /**
     * 因360影视登录页改版过大，影响脚本运行
     * 顾现采用365漂漂网作为演示案例
     */


    private static WebDriver driver;
    /***
     * 用来传递WebDriver
     * @return
     */
    public static WebDriver driver() {
        return driver;
    }
    public HomePage() {
        //设置系统变量，并设置chromedriver的路径为系统属性值
        System.setProperty("webdriver.chrome.driver","tool/chromedriver.exe");
        //实例ChromeDriver
        driver = new ChromeDriver();
        PageFactory.initElements(driver,this);
    }
    /**
     * 打开浏览器
     */
    public void open() {
        driver.get("http://manage.365pp.com/");
    }
    /**
     * 关闭浏览器
     */
    public void close() {
        driver.quit();
    }
    public LoginPage loginPage() {
        LoginPage loginPage = new LoginPage();
        return loginPage;
    }
}