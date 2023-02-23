package com.dumiduh.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.dumiduh.constants.Constants.BROWSER;
import static com.dumiduh.constants.Constants.RUN_HEADLESS;

public class TestBase {
    protected static WebDriver driver;

    public static void instantiateDriver() {
        if (BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (RUN_HEADLESS.equals("true")) {
                options.addArguments("headless");
            }
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (BROWSER.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");

            if (RUN_HEADLESS.equals("true")) {
                options.addArguments("headless");
            }
            driver = new EdgeDriver(options);
        } else{
            Logger.getAnonymousLogger().log(Level.INFO,"An unsupported browser argument was provided at run-time.");
        }


    }
}
