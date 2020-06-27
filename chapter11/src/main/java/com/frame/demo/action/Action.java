package com.frame.demo.action;

import com.frame.demo.page.BasePage;
public class Action extends BasePage {
    public void sendKeys(String name,String str) {
        findElement(name).clear();
        findElement(name).sendKeys(str);
    }
    public void click(String name) {
        findElement(name).click();
    }
    public String getText(String name) {
        return findElement(name).getText();
    }
}