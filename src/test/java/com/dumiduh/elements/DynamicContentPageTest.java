package com.dumiduh.elements;


import com.dumiduh.function.DynamicContentPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.DYNAMIC_CONTENT_URL;

/***
 * The objective of this test is to demonstrate how dynamic content can be handled.
 */
public class DynamicContentPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(DYNAMIC_CONTENT_URL);
    }

    @Test
    public static void dynamicContentTest() {
        DynamicContentPageFunctions dynamicContentPage = new DynamicContentPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("003");

        //Asserts to aspects of the dynamic content loaded on the page.
        Assert.assertTrue(dynamicContentPage.isTheDynamicContentAvailable(), "The dynamic content was not available");
        Assert.assertEquals(dynamicContentPage.numberOfRowsContentDisplayed(), testData.getIntValue(), "The number of rows displayed is not as expected.");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
