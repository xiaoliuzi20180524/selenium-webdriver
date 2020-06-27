package com.demo.test;

/**
 * @author rongrong
 * @version 1.0
 * @description Maven编译和测试案例
 * @date 2020/6/26 12:59
 */
public class HelloWorld {
    public String sayHello() {
        return "Hello World";
    }

    public static void main( String[] args ) {
        System.out.println(new HelloWorld().sayHello());
    }
}
