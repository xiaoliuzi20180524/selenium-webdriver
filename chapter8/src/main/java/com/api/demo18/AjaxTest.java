package com.api.demo18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


/**
 * @description Ajax浮动框处理案例
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 9:59
 */
public class AjaxTest {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void teatAjaxDivOption() throws Exception {
        driver.get("https://www.hao123.com/");
        //hao123首页搜索输入框
        WebElement searchInput = driver.findElement(By.name("word"));
        //单击搜索框
        searchInput.click();
        Thread.sleep(2000);
        //将浮动框中的所有元素放到list集合中
        List<WebElement> options = driver.findElements(By.cssSelector("[data-query]"));
        /*
         * 使用for循环遍历所有选项，判断如果选项包含某些关键字
         * 则点击这个选项，单击后选项的文字内容会显示在搜索框中，并进行搜索
         */
        for(WebElement element: options){
            if(element.getText().contains("许飞写的姐姐们")){
                System.out.println(element.getText());
                Thread.sleep(2000);
                element.click();
                Thread.sleep(1000);
                break;
            }
        }
    }
}