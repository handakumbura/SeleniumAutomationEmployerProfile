package com.dumiduh.elements;

import com.dumiduh.function.CheckBoxPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.CHECKBOX_PAGE_URL;

/***
 *  The objective of this test is to show how a checkbox can be handled.
 */

public class CheckBoxPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(CHECKBOX_PAGE_URL);
    }

    @Test
    public static void checkBoxTest() {
        CheckBoxPageFunctions checkBoxPageFunctions = new CheckBoxPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("001");
        checkBoxPageFunctions.checkCheckBoxValue(testData.getStringValue());

        //Asserts to see if the checkbox has been checked.
        Assert.assertTrue(checkBoxPageFunctions.isTheGivenCheckBoxChecked(testData.getStringValue()), "The given checkbox was not checked.");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
