package com.api.demo14;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @description 截图操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 9:05
 */
public class TestTakeScreenshout {


    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 通过截图类TakeScreenshout实现截图
     *
     * @throws Exception
     */
    @Test
    public void testScreenshoutByTakesScreenshot() {
        driver.get("https://www.cnblogs.com/longronglang");
        //执行屏幕截图操作
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //通过FileUtils中的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
        try {
            FileUtils.copyFile(srcFile,new File("D:\\screenshot\\通过TakesScreenshot截图.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过Robot实现截图操作
     */
    @Test
    public void testScreenshoutByRobot() {
        driver.get("https://www.cnblogs.com/longronglang");
        //调用截图方法
        BufferedImage img = null;
        try {
            img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(img,"jpg",new File("D:\\screenshot\\通过Robot截图.jpg"));
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 通过指定元素及区域大小截图
     */
    @Test
    public void testScreenshoutByElement() {
        driver.get("https://www.cnblogs.com/longronglang");
        //获取页面看板娘元素
        WebElement element = driver.findElement(By.cssSelector("[width='180px']"));
        try {
            FileUtils.copyFile(captureElement(element),new File("D:\\screenshot\\通过element元素及区域大小截图.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 页面元素截图
     *
     * @param element
     * @return
     * @throws Exception
     */
    public static File captureElement(WebElement element) throws Exception {
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        // 截图整个页面
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screen);
        // 获得元素的高度和宽度
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // 创建一个矩形使面上面的高度，和宽度
        Rectangle rect = new Rectangle(width,height);
        // 得到元素的坐标
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(),p.getY(),rect.width,rect.height);
        // 存为jpg格式
        ImageIO.write(dest,"jpg",screen);
        return screen;
    }
}
