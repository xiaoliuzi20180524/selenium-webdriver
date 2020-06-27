package com.api.demo8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description  单选框、复选框处理
 * @author rongrong
 * @version 1.0
 * @date 2020/6/26 23:47
 */
public class RadioAndCheckBox {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 单选框处理
     */
    @Test
    public void testRadio() {
        driver.get("http://localhost:8080/CheckBoxRadioDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //获取第1个单选框李白元素对象
        WebElement element = driver.findElement(By.cssSelector("[value='0']"));
        boolean isSelected = element.isSelected();
        //查看李白是否被选中
        if (isSelected){
            System.out.println("李白已被选中，你只能选下一个英雄了");
        }
        //获取第3个单选框露娜元素对象
        element = driver.findElement(By.cssSelector("[value='2']"));
        //判断是否被选中
        if(!element.isSelected()){
            //如果未被选中，就可以直接选了
            element.click();
        }
    }

    /**
     * 复选框处理
     */
    @Test
    public void testCheckbox() {
        driver.get("http://localhost:8080/CheckBoxRadioDemo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        //获取第三个复选框公孙离元素对象
        WebElement element = driver.findElement(By.name("checkbox3"));
        boolean isSelected = element.isSelected();
        //如果选中取消选中
        if (isSelected){
            element.click();
        }
        /**
         * 全选操作
         */
        List<WebElement> elements = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement webElement :elements) {
            //点击选中
            webElement.click();
        }
    }
}
