package com.frame.demo.utils;

import java.util.Locale;
import java.util.ResourceBundle;
public class BaseInfo {
    public static String getBrowserType() {
        return getInfo("browserType");
    }
    public static String getUrl() {
        return getInfo("url");
    }
    public static String getInfo(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("config",Locale.CHINA);
        String value = bundle.getString(key);
        return value;
    }
}