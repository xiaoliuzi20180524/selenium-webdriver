package com.grid.demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestSeleniumGrid {


    @Test
    public void testSeleniumGrid1() {
        WebDriver chromeDriver = RemoteWebDriverUtil.createRemoteChromeDriver();
        chromeDriver.get("https://www.baidu.com/");
        chromeDriver.findElement(By.id("kw")).sendKeys("久曲健 博客园");
        chromeDriver.findElement(By.id("su")).click();
        System.out.println(chromeDriver.getTitle());
        //远程截图时必须这样操作
        chromeDriver=new Augmenter().augment(chromeDriver);
        //执行屏幕截图操作
        File srcFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        //通过FileUtils中的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
        try {
            FileUtils.copyFile(srcFile,new File("C:\\远程截图.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSeleniumGrid2() {
        WebDriver ieDriver = RemoteWebDriverUtil.createRemoteIEDriver();
        ieDriver.get("https://www.baidu.com/");
        ieDriver.findElement(By.id("kw")).sendKeys("久曲健 博客园");
        ieDriver.findElement(By.id("su")).click();
        System.out.println(ieDriver.getTitle());
        //远程截图时必须这样操作
        ieDriver=new Augmenter().augment(ieDriver);
        //执行屏幕截图操作
        File srcFile = ((TakesScreenshot) ieDriver).getScreenshotAs(OutputType.FILE);
        //通过FileUtils中的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
        try {
            FileUtils.copyFile(srcFile,new File("C:\\远程截图.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}