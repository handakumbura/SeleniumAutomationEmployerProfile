package com.dumiduh.elements;


import com.dumiduh.constants.Constants;
import com.dumiduh.function.SliderPageFunctions;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The objective of this test class is to demonstrate how sliders can be handled.
 */

public class SliderPageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.SLIDER_PAGE);
    }

    @Test
    public static void dynamicContentTest() {
        SliderPageFunctions sliderPageFunctions = new SliderPageFunctions(driver);
        sliderPageFunctions.moveSlider(10);
        Assert.assertEquals(sliderPageFunctions.getSliderValue(), "3");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
