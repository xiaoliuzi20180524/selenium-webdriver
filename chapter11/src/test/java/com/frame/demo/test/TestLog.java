package com.frame.demo.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog {
    /**
     * log4j日志
     */
    private static Logger logger = Logger.getLogger(TestLog.class);
    @Test
    public void testLog() {
        logger.info("this is info log!!");
        logger.error("this is error log!!");
    }
}