package com.dumiduh.elements;

import com.dumiduh.constants.Constants;
import com.dumiduh.function.DropDownPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The objective of this test class is to demonstrate how a dropdown maybe handled.
 */
public class DropDownPageTest extends TestBase {
    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test
    public static void dropDownTest() {
        DropDownPageFunctions dropDownPageFunctions = new DropDownPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("002");

        dropDownPageFunctions.selectValueFromDropDown(testData.getStringValue());

        //Asserts to see if the dropdown selection has been set.
        Assert.assertTrue(dropDownPageFunctions.isTheGivenValueSelected(testData.getStringValue()), "The given value was not set as the dropdown selection.");
    }

    @AfterClass
    public static void cleanUp(){
        driver.quit();
    }
}
