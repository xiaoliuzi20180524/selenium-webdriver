package com.frame.demo.page;

import com.frame.demo.base.GetDriverUtil;
import com.frame.demo.utils.BaseInfo;
import com.frame.demo.utils.ReadExcelUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;
public class BasePage {
    private static Logger logger = Logger.getLogger(BasePage.class);
    static WebDriver driver;
    Map<String,String> elementData;
    public BasePage() {
        String browserType = BaseInfo.getBrowserType();
        driver = GetDriverUtil.getDriver(browserType);
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
        elementData = ReadExcelUtil.getElementData();
    }
    private By getBy(String method,String methodValue) {
        if (method.equalsIgnoreCase("id")) {
            return By.id(methodValue);
        } else if (method.equalsIgnoreCase("name")) {
            return By.name(methodValue);
        } else if (method.equalsIgnoreCase("tagName")) {
            return By.tagName(methodValue);
        } else if (method.equalsIgnoreCase("className")) {
            return By.className(methodValue);
        } else if (method.equalsIgnoreCase("linkText")) {
            return By.linkText(methodValue);
        } else if (method.equalsIgnoreCase("xpath")) {
            return By.xpath(methodValue);
        } else if (method.equalsIgnoreCase("cssSelector")) {
            return By.cssSelector(methodValue);
        } else {
            return By.partialLinkText(methodValue);
        }
    }
    public WebElement findElement(String name) {
        String data = elementData.get(name).toString();
        String method = data.split("，")[0];
        String methodValue = data.split("，")[1];
        logger.info("获取元素控件 " + name);
        return driver.findElement(this.getBy(method,methodValue));
    }
    public void switchToFrame(int frame) {
        driver.switchTo().frame(frame);
    }
    public void open() {
        String url = BaseInfo.getUrl();
        logger.info("打开163邮箱首页");
        driver.get(url);
    }
    public void quit() {
        logger.info("关闭浏览器成功！");
        driver.quit();
    }
}