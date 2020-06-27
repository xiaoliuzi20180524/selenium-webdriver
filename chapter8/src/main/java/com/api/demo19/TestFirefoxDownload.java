package com.api.demo19;

import java.io.File;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @description 使用Firefox浏览器下载文件到指定目录演示示例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 11:59
 */
public class TestFirefoxDownload {
    WebDriver driver;

    /**
     * 由于jar包及浏览器的更新，导致书中代码陈旧，具体参考我的博客文章，地址如下：
     * https://www.cnblogs.com/longronglang/p/7417389.html
     */
    @BeforeClass
    public void beforeClass() {
        driver = getDriver();
    }

    /**
     * 设置火狐浏览器默认参数
     *
     * @return
     */
    private WebDriver getDriver() {
        //FirefoxProfile profile = new FirefoxProfile();
        // 可以在Firefox浏览器地址栏中输入about:config来查看属性
        // 设置下载文件放置路径,注意如果是windows环境一定要用\\,用/不行
        String path = "C:\\wps";
        String downloadFilePath = path + "\\demo.exe";
        File file = new File(downloadFilePath);
        if (file.exists()) {
            file.delete();
        }
        FirefoxOptions options = new FirefoxOptions();
        //声明一个profile对象
        FirefoxProfile profile = new FirefoxProfile();
        //设置Firefox的“broswer.download.folderList”属性为2
        /**
         * 如果没有进行设定，则使用默认值 1，表示下载文件保存在“下载”文件夹中
         * 设定为0，则下载文件会被保存在用户的桌面上
         * 设定为2，则下载的文件会被保存的用户指定的文件夹中
         */
        profile.setPreference("browser.download.folderList", 2);
        //browser.download.manager.showWhenStarting的属性默认值为true
        //设定为 true ， 则在用户启动下载时显示Firefox浏览器的文件下载窗口
        //设定为false，则在用户启动下载时不显示Firefox浏览器的文件下载窗口
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        //设定文件保存的目录
        profile.setPreference("browser.download.dir", path);
        //browser.helperApps.neverAsk.openFile 表示直接打开下载文件，不显示确认框
        //默认值.exe类型的文件，"application/excel"表示Excel类型的文件
        //	application/x-msdownload
        profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
        //browser.helperApps.never.saveToDisk 设置是否直接保存 下载文件到磁盘中默认值为空字符串，厦航代码行设定了多种温江的MIME类型
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
        //browser.helperApps.alwaysAsk.force 针对位置的MIME类型文件会弹出窗口让用户处理，默认值为true ，设定为false 表示不会记录打开未知MIME类型文件
        profile.setPreference("browser.helperApps.alwaysAsk.force", true);
        //下载.exe文件弹出窗口警告，默认值是true ，设定为false 则不会弹出警告框
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        //browser.download.manager.focusWhenStarting设定下载框在下载时会获取焦点
        profile.setPreference("browser.download.manager.focusWhenStarting", true);
        //browser.download.manager.useWindow 设定下载是否现在下载框，默认值为true，设定为false 会把下载框隐藏
        profile.setPreference("browser.download.manager.useWindow", false);
        //browser.download.manager.showAlertOnComplete 设定下载文件结束后是否显示下载完成的提示框，默认值为true，
        //设定为false表示下载完成后，现在下载完成提示框
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        //browser.download.manager.closeWhenDone 设定下载结束后是否自动关闭下载框，默认值为true 设定为false 表示不关闭下载管理器
        profile.setPreference("browser.download.manager.closeWhenDone", false);
        options.setProfile(profile);
        //设置系统变量，并设置 geckodriver 的路径为系统属性值
        System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
        //导入Firefox浏览器安装路径
        System.setProperty("webdriver.firefox.bin", "E:/Program Files/Mozilla Firefox/firefox.exe");
        return new FirefoxDriver(options);
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("http://localhost:8080/download.html");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("下载")).click();
        Thread.sleep(3000);
    }
}