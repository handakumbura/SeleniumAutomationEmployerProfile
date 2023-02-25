package com.dumiduh.elements;

import com.dumiduh.function.DropDownPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.dumiduh.constants.Constants.DROPDOWN_PAGE_URL;

/**
 * The objective of this test class is to demonstrate how a dropdown maybe handled.
 */
public class DropDownPageElementsTest extends TestBase {
    @BeforeClass
    public static void setup() {
        instantiateDriver();

    }

    @Test
    public static void dropDownPageElementTest() {
        TestData data = JSONUtil.readAGivenTestDataItem("dropDownPageElementTest");
        driver.get(DROPDOWN_PAGE_URL);
        DropDownPageFunctions dropdown = new DropDownPageFunctions(driver);
        Assert.assertTrue(dropdown.isTheDropDownHeadingDisplayed());
        Assert.assertTrue(dropdown.isTheDropDownDisplayed());

        Assert.assertEquals(data.getNumberOfOptions(), dropdown.getTheListOfOptions().size());
        if(dropdown.getTheListOfOptions().containsAll(data.getListOfOptions())){
            Assert.assertTrue(true);
        }
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
