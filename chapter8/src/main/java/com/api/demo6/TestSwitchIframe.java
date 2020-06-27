package com.api.demo6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @description iframe切换处理
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:25
 */
public class TestSwitchIframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 使用iframe标签位置切换
     */
    @Test
    public void testSwitchIframe1() {
        driver.get("http://localhost:8080/iframeDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //用iframe标签的位置切换，本页面就一个iframe框，故此写0，表示第一个标签
        driver.switchTo().frame(0);
        //进入iframe内，在输入框输入软件测试君
        driver.findElement(By.id("user")).sendKeys("软件测试君");
    }

    /**
     * 使用元素对象进行iframe切换
     */
    @Test
    public void testSwitchIframe2() {
        driver.get("http://localhost:8080/iframeDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //获得iframe元素对象
        WebElement iframe = driver.findElement(By.id("iframe"));
        //使用元素对象进行iframe切换
        driver.switchTo().frame(iframe);
        //进入iframe内，在输入框输入软件测试君
        driver.findElement(By.id("user")).sendKeys("软件测试君");
    }

    /**
     * 使用id属性进行iframe切换
     */
    @Test
    public void testSwitchIframe3() {
        driver.get("http://localhost:8080/iframeDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //使用id属性进行iframe切换
        driver.switchTo().frame("iframe");
        //进入iframe内，在输入框输入软件测试君
        driver.findElement(By.id("user")).sendKeys("软件测试君");
    }

    /**
     * 使用name属性进行iframe切换
     */
    @Test
    public void testSwitchIframe4() {
        driver.get("http://localhost:8080/iframeDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //使用id属性进行iframe切换
        driver.switchTo().frame("iframeName");
        //进入iframe内，在输入框输入软件测试君
        driver.findElement(By.id("user")).sendKeys("软件测试君");
    }


    /**
     * 切换实际案例
     */
    @Test
    public void testIframeDemo() {
        driver.get("https://mail.163.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //选择密码登录,由于网站改版注释掉密码登录
        //driver.findElement(By.linkText("密码登录")).click();
        //进入iframe，本页面就一个iframe，所以写0就可以
        driver.switchTo().frame(0);
        //输入邮箱账号
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("your Mail");
        //输入密码
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("your passWord");
        //点击登录按钮
        driver.findElement(By.id("dologin")).click();
        //错误提示语
        String msg = driver.findElement(By.cssSelector(".ferrorhead")).getText();
        //验证输入账号格式错误是否提示帐号格式错误
        Assert.assertEquals(msg,"帐号格式错误");
        //跳出iframe返回主页面内容
        driver.switchTo().defaultContent();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
