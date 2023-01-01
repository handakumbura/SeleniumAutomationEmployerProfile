package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.CustomBy;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/***
 * The objective of this test is to demonstrate the use of a custom locator.
 */

public class CustomeLocatorTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.DYNAMIC_LOAD);
    }

    @Test
    public static void byContainsText() {
        Assert.assertTrue(driver.findElement(CustomBy.containsText("Powered by")).isDisplayed(), "the expected text value was not found in the html document.");
    }


    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
