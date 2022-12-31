package com.dumiduh.elements;

import com.dumiduh.constants.Constants;
import com.dumiduh.function.NotificationPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The objective of this test class is to demonstrate how notification messages can be handled.
 */

public class NotificationMessagePageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(Constants.NOTIFICATION_PAGE_URL);
    }

    @Test
    public static void notificationTest() {
        NotificationPageFunctions notificationPageFunctions = new NotificationPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("005");

        notificationPageFunctions.displayTheNotification();

        //Asserts two aspects of the dynamic notification.
        Assert.assertTrue(notificationPageFunctions.readTheDisplayedNotification().length() > testData.getIntValue(), "The expected notification was not found.");
        Assert.assertTrue(notificationPageFunctions.readTheDisplayedNotification().contains( testData.getStringValue()), "The expected notification was not found.");
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
