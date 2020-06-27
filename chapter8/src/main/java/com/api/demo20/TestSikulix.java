package com.api.demo20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @description Selenium结合sikuliX操作Flash网页案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 12:59
 */
public class TestSikulix {


    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSikuli() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.get("http://map.baidu.com/");
        //打开城市下拉框
        driver.findElement(By.cssSelector(".ui3-city-change-inner")).click();
        //选择北京
        driver.findElement(By.cssSelector("[citycode='131']")).click();;
        // 打开工具下拉框
        driver.findElement(By.cssSelector("[map-on-click='box'] em")).click();
        // 选择测距
        driver.findElement(By.cssSelector("[map-on-click='measure'] i")).click();
        Screen screen = new Screen();
        String start = "D:\\picture\\奥林匹克森林公园.png";
        String end = "D:\\picture\\西红门南桥.png";
        Pattern from = new Pattern(start);
        Pattern to = new Pattern(end);
        try {
            if (screen.find(from) != null) {
                screen.click(from);
            }
            if (screen.find(to) != null) {
                screen.click(to);
            }
            screen.doubleClick();
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}