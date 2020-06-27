package com.grid.demo;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteWebDriverUtil {
    static WebDriver driver;
    // 远程调用ie浏览器
    public static WebDriver createRemoteIEDriver() {
        System.setProperty("webdriver.ie.driver","tool/IEDriverServer.exe");
        // 指定调用IE进行测试  
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        // 避免IE安全设置里，各个域的安全级别不一致导致的错误  
        capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        // 连接到selenium hub，远程启动浏览器  
        capability.setPlatform(Platform.XP);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.118:5555/wd/hub"),capability);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver;
    }
    // 启用远程调用chrome
    public static WebDriver createRemoteChromeDriver() {
        System.setProperty("webdriver.chrome.driver","tool/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("--disable-extensions--");
        options.addArguments("proxy=null");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.XP);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.118:5555/wd/hub"),capability);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver;
    }
    // 启用远程调用firefox
    public static WebDriver createRemoteFirefoxDriver() {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.XP);
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.106:4444/wd/hub"),capability);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return driver;
    }
}