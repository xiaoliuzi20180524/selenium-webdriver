package com.data.demo;

import org.testng.annotations.Test;

import java.util.Map;
/**
 * @description 读取mysql数据库
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 14:22
 */
public class TestDbData extends DbDataHeleper {

    @Test(dataProvider = "dbDataMethod")
    public void testmethod1(Map<?, ?> param) {
        System.out.println(param.get("username") + "\t" + param.get("passWord") + "\t" + param.get("remark"));
    }
}