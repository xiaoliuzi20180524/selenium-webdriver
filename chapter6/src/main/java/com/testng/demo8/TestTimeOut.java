package com.testng.demo8;

import org.testng.annotations.Test;

/**
 * @author rongrong
 * @version 1.0
 * @description
 * @date 2020/6/26 14:19
 */
public class TestTimeOut {
    @Test(timeOut = 3000)
    public void testTimeout(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
