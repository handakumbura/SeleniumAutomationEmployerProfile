package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GetScreenshotTest extends TestBase {
    private static final String SAVED_IMAGE_FULLY_QUALIFIED_URL = "C:\\SOFTWARE\\screenshot.png";

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test(enabled = false)
    public static void dropDownTest() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File savedScreensot = new File(SAVED_IMAGE_FULLY_QUALIFIED_URL);
        try {
            FileUtils.copyFile(screenshot, savedScreensot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
