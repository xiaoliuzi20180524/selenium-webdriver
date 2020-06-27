package com.api.demo1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * @description 浏览器操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 19:02
 */
public class TestBrowerApi {
    WebDriver driver;

    /**
     * 访问某个网站
     */
    @Test
    public void testOpen() {
        driver = new ChromeDriver();
        //打开某个页面
        driver.get("https://www.baidu.com/");
    }

    /**
     * 浏览器最大化
     */
    @Test
    public void testGoto() {
        driver = new ChromeDriver();
        //跳转到某个网站（个人喜欢这么理解区分）
        driver.navigate().to("https://www.baidu.com/");
    }

    /**
     * 浏览器前进、后退操作
     * @throws Exception
     */
    @Test
    public void testForwardAndBackward() throws Exception {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //程序等待3秒
        Thread.sleep(3000);
        //打开360搜索页面
        driver.navigate().to("https://www.so.com/");
        //程序等待3秒
        Thread.sleep(3000);
        //后退操作
        driver.navigate().back();
        //程序等待3秒
        Thread.sleep(3000);
        //前进操作
        driver.navigate().forward();
    }

    /**
     * 浏览器刷新操作
     * @throws Exception
     */
    @Test
    public void testRefresh() throws Exception {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //刷新操作
        driver.navigate().refresh();
    }


    /**
     * 浏览器窗口操作
     */
    @Test
    public void testWindow(){
        driver.get("https://www.baidu.com/");
        //浏览器窗口最大化操作
        driver.manage().window().maximize();
        //设置窗口大小
        driver.manage().window().setSize(new Dimension(375,600));
        //设置窗口在哪个位置处打开显示
        driver.manage().window().setPosition(new Point(400,500));
        //全屏操作
        driver.manage().window().fullscreen();
    }

    /**
     * 获取页面标题（title属性）
     * @throws Exception
     */
    @Test
    public void testGetTitle() throws Exception {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获取页面title属性
        String title = driver.getTitle();
        System.out.println(title);
    }

    /**
     * 获取页面源代码信息
     * @throws Exception
     */
    @Test
    public void testGetPageSource() throws Exception {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获取页面源代码
        String pageSource = driver.getPageSource();
        //输出页面源代码
        System.out.println(pageSource);
    }


    /**
     * 获取当前页面URL地址
     * @throws Exception
     */
    @Test
    public void testGetCurrentUrl() throws Exception {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获取当前页面URL地址
        String currentUrl = driver.getCurrentUrl();
        //输出URL信息
        System.out.println(currentUrl);
    }

    /**
     * 关闭浏览器操作
     */
    @Test
    public void testClose() {
        driver.get("https://www.baidu.com/");
        //浏览器最大化
        driver.manage().window().maximize();
        //退出并关闭所有句柄
        driver.quit();
        //仅关闭当前tab即句柄
        //driver.close();
    }
}
