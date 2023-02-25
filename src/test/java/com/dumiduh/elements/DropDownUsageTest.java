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
public class DropDownUsageTest extends TestBase {
    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test
    public static void dropDownUsageTest() {
        DropDownPageFunctions dropDownPageFunctions = new DropDownPageFunctions(driver);
        TestData testData = JSONUtil.readAGivenTestDataItem("dropDownUsageTest");

        dropDownPageFunctions.selectValueFromDropDown(testData.getDropDownSelection());
        //Asserts to see if the dropdown selection has been set.
        Assert.assertTrue(dropDownPageFunctions.isTheGivenValueSelected(testData.getDropDownSelection()));
    }

    @AfterClass
    public static void cleanUp(){
        driver.quit();
    }
}
