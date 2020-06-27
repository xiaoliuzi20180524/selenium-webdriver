package com.pagefactory.demo;

import org.testng.annotations.Test;

public class TestPageFactory {
    /**
     * 测试登录
     */
    @Test
    public void testLogin() {
        //实例化操作对象
        LoginMovies loginMovies = new LoginMovies();
        //登录操作
        loginMovies.loginByPageFactory("your userName","your passWord","正在登录!请稍后...");
    }
}