package com.dumiduh.elements;


import com.dumiduh.function.BrokenImagePageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.BASE_PAGE;

/***
 *  The objective of this test is to demonstrate how a broken image link may be asserted.
 */

public class BrokenImagePageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(BASE_PAGE);
    }

    @Test
    public static void brokenImageTest() {
        TestData testData = JSONUtil.readTestData("006");
        BrokenImagePageFunctions brokenImagePageFunctions = new BrokenImagePageFunctions(driver);
        Assert.assertEquals(brokenImagePageFunctions.getStatusCodeOfImage(testData.getStringValue()), 404);
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
