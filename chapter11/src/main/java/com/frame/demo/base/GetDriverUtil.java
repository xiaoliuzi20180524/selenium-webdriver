package com.frame.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDriverUtil {

    /**
     * @param browersName
     * @return
     */
    public static WebDriver getDriver(String browersName) {
        if (browersName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "tool/geckodriver.exe");
            System.setProperty("webdriver.firefox.bin", "E:/Program Files/Mozilla Firefox/firefox.exe");
            return new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "tool/chromedriver.exe");
            return new ChromeDriver();
        }
    }

}