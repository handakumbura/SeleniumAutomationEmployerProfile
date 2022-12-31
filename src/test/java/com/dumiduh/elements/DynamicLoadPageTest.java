package com.dumiduh.elements;


import com.dumiduh.function.DynamicPageFunctions;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.DYNAMIC_LOAD_PAGE;

/***
 * The objective of this test class is to demonstrate how dynamic page loads can be handled.
 */

public class DynamicLoadPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(DYNAMIC_LOAD_PAGE);
    }

    @Test
    public static void dynamicContentTest() {
        DynamicPageFunctions dynamicPageFunctions = new DynamicPageFunctions(driver);
        dynamicPageFunctions.clickTheStartButton();
        dynamicPageFunctions.waitForTheProgressBarToDisappear();
        Assert.assertEquals(dynamicPageFunctions.getTheFinalText(), "Hello World!");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
