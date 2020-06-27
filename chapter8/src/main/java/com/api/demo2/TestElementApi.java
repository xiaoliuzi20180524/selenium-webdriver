package com.api.demo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @description 元素操作
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 20:39
 */
public class TestElementApi {
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        //设定Chrome浏览器驱动程序所在位置为系统属性值
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        //将driver实例化为ChromeDriver对象
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * click形式点击
     * @throws Exception
     */
    @Test
    public void testButton() throws Exception {
        driver.get("http://localhost:8080/clcik.html");
        //获得元素对象即可用按钮
        WebElement button1 = driver.findElement(By.id("button1"));
        //获得元素对象即不可用按钮
        WebElement button2 = driver.findElement(By.id("button2"));
        //判断按钮是否可以点击
        if(button2.isEnabled()){
            button2.click();
        }
        //判断按钮是否可以点击
        boolean isEnable= button1.isEnabled();
        if(isEnable){
            //如可点击，则点击可用按钮
            button1.click();
        }
    }


    /***
     * submit形式点击
     */
    @Test
    public void testSubmit(){
        driver.get("http://localhost:8080/submit.html");
        //获得元素对象登录按钮
        WebElement submit = driver.findElement(By.id("login"));
        //判断按钮是否可以点击
        boolean isDisplayed= submit.isDisplayed();
        if(isDisplayed){
            //如可点击，则点击可用按钮
            submit.click();
        }
    }

    /***
     * 输入操作
     * @throws Exception
     */
    @Test
    public void testInput() throws Exception {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得元素对象即可用按钮
        WebElement input = driver.findElement(By.id("kw"));
        //清空默认文本
        input.clear();
        //在百度输入框中输入Refain 博客园
        input.sendKeys("Refain 博客园");
    }

    /**
     * 获取页面元素文本操作
     */
    @Test
    public void testGetText() {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得新闻元素对象
        WebElement linkText = driver.findElement(By.linkText("新闻"));
        //输出新闻元素页面文本
        System.out.println(linkText.getText());
    }

    /**
     * 获取页面元素标签名称操作
     */
    @Test
    public void testGetTagName() {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得新闻元素对象
        WebElement linkText = driver.findElement(By.linkText("新闻"));
        //输出新闻元素标签
        System.out.println(linkText.getTagName());
    }

    /**
     * 获取页面元素属性值操作
     */
    @Test
    public void testGetAttribute() {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得百度一下按钮对象
        WebElement button = driver.findElement(By.id("su"));
        //输出百度按钮的value属性值
        System.out.println(button.getAttribute("value"));
    }

    /**
     *获取页面元素的尺寸操作
     */
    @Test
    public void testGetSize() {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得百度一下按钮对象
        WebElement button = driver.findElement(By.id("su"));
        //输出百度按钮尺寸
        System.out.println(button.getSize());
    }

    /**
     * 获取页面元素的CSS样式操作
     */
    @Test
    public void testGetCssValue() {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得百度一下按钮对象
        WebElement button = driver.findElement(By.id("su"));
        //输出百度按钮的css属性background值
        System.out.println(button.getCssValue("background"));
    }

    /**
     * 获取页面元素的坐标操作
     */
    @Test
    public void testGetLocation() {
        driver = new ChromeDriver();
        //打开百度首页
        driver.get("https://www.baidu.com/");
        //获得百度一下按钮对象
        WebElement button = driver.findElement(By.id("su"));
        //输出百度按钮的坐标
        System.out.println(button.getLocation());
    }

    /**
     * 获取页面多个元素操作
     */
    @Test
    public void testFindElements() {
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        //定位所有超链接元素，即a标签个数，返回一个list集合
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        //打印百度首页中超链接的个数
        System.out.println(elements.size());
    }
}
