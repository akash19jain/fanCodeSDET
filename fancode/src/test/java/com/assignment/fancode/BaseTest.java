package com.assignment.fancode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public Logger LOGGER;

    @BeforeClass
    public void setUp() {
        LOGGER = LogManager.getLogger(this.getClass());
        LOGGER.info("IN BASE TEST CLASS");
    }

}
