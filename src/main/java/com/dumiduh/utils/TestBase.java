package com.dumiduh.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.dumiduh.constants.Constants.RUN_HEADLESS;

public class TestBase {
    protected static ChromeDriver driver;

    public static void instantiateChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        //runs selenium in headless mode if the argument is massed at run time.
        if (Boolean.getBoolean(RUN_HEADLESS)) {
            options.addArguments("headless");
        }
        driver = new ChromeDriver(options);
    }
}
