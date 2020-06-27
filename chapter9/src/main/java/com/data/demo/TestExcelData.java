package com.data.demo;

import org.testng.annotations.Test;

import java.util.Map;

/**
 * @description 利用Excel文件做数据驱动测试
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 13:22
 */
public class TestExcelData extends ExcelData {


    @Test(dataProvider = "dataMethod")
    public void testmethod(Map<?, ?> param) {
        System.out.println(param.get("userName") + "\t" + param.get("passWord"));
    }


}