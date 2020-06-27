package com.data.demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @description 利用CSV文件做数据驱动测试
 * @author rongrong
 * @version 1.0
 * @date 2020/6/27 13:22
 */
public class TestCSVData {


    /**
     * 读取csv文件
     *
     * @param filePath
     * @return返回list集合
     */
    public List<Map<String, String>> getCSVData(String filePath) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        ;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            //通过for循环遍历，将读取的每一行数据使用逗号进行分割并保存到map中
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                Map<String, String> map = new HashMap<String, String>();
                String key = line.split(",")[0];
                String value = line.split(",")[1];
                map.put("userName", key);
                map.put("passWord", value);
                //再将map对象放到list集合中
                list.add(map);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @DataProvider
    public Object[][] testCSVData() {
        //读取csv文件数据，调用getCSVData()方法来获得测试的数据
        List<Map<String, String>> result = getCSVData("d:\\data.csv");
        Object[][] files = new Object[result.size()][];
        //通过for循环遍历list，每一行的数据都会通过构造函数来进行初始化赋值
        for (int i = 0; i < result.size(); i++) {
            files[i] = new Object[]{result.get(i)};
        }
        return files;
    }


    @Test(dataProvider = "testCSVData")
    public void testCSVData(Map<String, String> param) {
        System.out.println(param.get("userName") + "\t" + param.get("passWord"));
    }
}