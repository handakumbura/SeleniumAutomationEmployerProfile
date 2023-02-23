package com.dumiduh.elements;

import com.dumiduh.constants.Constants;
import com.dumiduh.function.DropDownPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The objective of this test class is to demonstrate how a dropdown maybe handled.
 */
public class DropDownPageElementsTest extends TestBase {
    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test(dataProviderClass = DropDownDataProvider.class, dataProvider = "generateTestData", testName = "dropDownPageElementTest")
    public static void dropDownPageElementTest(TestData data) {
        data.getStringValue();
    }

    @AfterClass
    public static void cleanUp(){
        driver.quit();
    }
}
