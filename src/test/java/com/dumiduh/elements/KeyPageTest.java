package com.dumiduh.elements;


import com.dumiduh.function.KeyPageFunctions;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.KEY_PRESS;

/**
 * The objective of this test class is to demonstrate how key presses can be handled.
 */

public class KeyPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(KEY_PRESS);
    }

    @Test()
    public static void keyPressTest() {
        KeyPageFunctions keyPageFunctions = new KeyPageFunctions(driver);
        keyPageFunctions.sendKey(Keys.ENTER);
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
