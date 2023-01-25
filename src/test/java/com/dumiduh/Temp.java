package com.dumiduh;

import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static com.dumiduh.constants.Constants.*;


public class Temp extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        data = JSONUtil.readTestData(); //reading input data from the test data file.
        driver.get(URL_TEMP);
    }

    @Test
    public static void validateTheProductSearchAndPricingData() {
        Logger logger = Logger.getLogger(Temp.class.getName());


    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
