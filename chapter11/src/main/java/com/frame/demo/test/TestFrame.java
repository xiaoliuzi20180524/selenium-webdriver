package com.frame.demo.test;

import com.frame.demo.object.LoginPage;
import org.testng.annotations.Test;
public class TestFrame extends LoginPage {
    @Test
    public void textLogin() throws Exception {
       login("your userName","your passWord","帐号格式错误");
    }
}