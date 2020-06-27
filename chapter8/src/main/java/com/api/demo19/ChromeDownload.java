package com.api.demo19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description 使用Chrome浏览器下载文件到指定目录演示案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 11:59
 */
public class ChromeDownload {

    @Test
    public void testChromeDownload() throws Exception {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        //使用Chrome浏览器自动下载文件并保存到指定的文件路径
        DesiredCapabilities caps = setDownloadsPath();
        WebDriver driver = new ChromeDriver(caps);
        driver.manage().window().maximize();
        //到目标网页，下载搜狗输入法app
        driver.get("https://shouji.sogou.com/download.php");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //选择安卓版本下载
        WebElement myElement = driver.findElement(By.cssSelector(".platCont [target='_blank']:nth-of-type(1) span"));
        Actions action = new Actions(driver);
        //点击下载
        myElement.click();

    }

    /***
     * 设定文件下载目录
     * @return
     */
    public DesiredCapabilities setDownloadsPath() {
        String downloadsPath = "C:\\wps";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", downloadsPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        return caps;
    }
}