package com.dumiduh.elements;

import com.dumiduh.function.RadioButtonPageFunctions;
import com.dumiduh.utils.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.RADIO_BUTTON;

public class RadiobuttonPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(RADIO_BUTTON);
    }

    @Test
    public static void radioButtonTest() {
        RadioButtonPageFunctions radioButtonPageFunctions = new RadioButtonPageFunctions(driver);
        radioButtonPageFunctions.selectRadioButtonByValue("CSS");
        //Assert.assertEquals(radioButtonPageFunctions.getValueOfTheSelectedOption(), "CSS");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
