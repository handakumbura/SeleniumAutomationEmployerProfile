package com.dumiduh.other;


import com.dumiduh.utils.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.dumiduh.constants.Constants.DROPDOWN_PAGE_URL;

/***
 * The objective of this test class is to demonstrate how to connect to a standalone selenium grid server.
 */

public class GridTest extends TestBase {
    private static WebDriver driver;

    @BeforeClass(enabled = false)
    public static void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("platformName", "Windows");
        try {
            URL url = new URL("http://localhost:4444/");
            driver = new RemoteWebDriver(url, options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(enabled = false)
    public static void test() {
        driver.get(DROPDOWN_PAGE_URL);
    }

    @AfterClass(enabled = false)
    public static void cleanUp() {
        driver.quit();
    }
}
