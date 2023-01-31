package com.dumiduh.other;


import com.dumiduh.constants.Constants;
import com.dumiduh.function.DropDownPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;


public class CrossMobileAgentTest extends TestBase {

    @AfterMethod
    public static void cleanUp() {
        driver.quit();
    }

    @Test(dataProvider = "userAgentsData")
    public static void crossMobileAgentTest(String s) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", s));
        driver = new ChromeDriver(options);
        driver.get(Constants.DROPDOWN_PAGE_URL);

        DropDownPageFunctions dropDownPageFunctions = new DropDownPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("002");

        dropDownPageFunctions.selectValueFromDropDown(testData.getStringValue());

        //Asserts to see if the dropdown selection has been set.
        Assert.assertTrue(dropDownPageFunctions.isTheGivenValueSelected(testData.getStringValue()), "The given value was not set as the dropdown selection.");
    }

    @DataProvider(name = "userAgentsData")
    public static Object[][] generateData() {
        return new String[][]{{"iPhone 5"}, {"iPhone 6"}, {"Nexus 6"}};
    }
}
