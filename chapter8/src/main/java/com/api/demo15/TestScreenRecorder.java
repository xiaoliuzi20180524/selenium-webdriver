package com.api.demo15;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @description 录制屏幕操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 9:25
 */
public class TestScreenRecorder {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    private static ScreenRecorder screenRecorder;

    @Test
    public void test() throws IOException,AWTException {
        GraphicsConfiguration gconfig = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        screenRecorder = new ScreenRecorder(gconfig,new Format(MediaTypeKey,
                MediaType.FILE,MimeTypeKey,MIME_AVI),new Format(
                MediaTypeKey,MediaType.VIDEO,EncodingKey,
                ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,CompressorNameKey,
                ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,DepthKey,(int) 24,
                FrameRateKey,Rational.valueOf(15),QualityKey,1.0f,
                KeyFrameIntervalKey,(int) (15 * 60)),new Format(MediaTypeKey,
                MediaType.VIDEO,EncodingKey,"black",FrameRateKey,
                Rational.valueOf(30)),null);
        // 开始捕获视频
        screenRecorder.start();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.navigate().to("https://www.baidu.com/");
        driver.manage().window().maximize();
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("kw")).sendKeys("selenium",Keys.ENTER);
            driver.navigate().forward();
            driver.navigate().back();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("D:screenshotsscreenshots1.jpg"));
        // 停止捕获视频
        screenRecorder.stop();
    }
}