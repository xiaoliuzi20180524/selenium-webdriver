package com.data.demo;

import org.testng.annotations.Test;

import java.util.Map;

/**
 * @description 利用YAML文件做数据驱动测试
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 14:01
 */
public class TestYamlData extends YamlDataHelper{

    @Test(dataProvider = "yamlDataMethod")
    public void testYamlData(Map<String,String> param){
        System.out.println(param.get("name")+"\t"+param.get("passwd"));
    }
}