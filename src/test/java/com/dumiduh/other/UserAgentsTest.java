package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.function.DropDownPageFunctions;
import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import com.dumiduh.utils.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;


public class UserAgentsTest extends TestBase {

    @BeforeClass()
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 6"));
        driver = new ChromeDriver(options);
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test()
    public static void multiAgentTest() {
        DropDownPageFunctions dropDownPageFunctions = new DropDownPageFunctions(driver);
        TestData testData = JSONUtil.readTestData("002");
        dropDownPageFunctions.selectValueFromDropDown(testData.getStringValue());
    }


    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
