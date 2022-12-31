package com.dumiduh.elements;

import com.dumiduh.function.InputPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.INPUT_PAGE_URL;

/***
 * The objective of this test class is to demonstrate how TextBoxes maybe handled.
 */
public class InputPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(INPUT_PAGE_URL);
    }

    @Test
    public static void inputTest() {
        InputPageFunctions inputPageFunctions = new InputPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("004");

        //Sets a numerical value.
        inputPageFunctions.setText(testData.getIntValue());
    }

    @AfterClass
    public static void cleanUp(){
        driver.quit();
    }
}
