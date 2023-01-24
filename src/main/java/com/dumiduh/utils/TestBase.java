package com.dumiduh.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.dumiduh.constants.Constants.*;

public class TestBase {
    protected static WebDriver driver;

    public static void instantiateDriver() {
        if (BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (RUN_HEADLESS.equals(TRUE)) {
                options.addArguments("headless");
            }

            if (MAXIMIZE_THE_WINDOW.equals(TRUE)) {
                options.addArguments("start-maximized");
            }

            driver = new ChromeDriver(options);
        } else if (BROWSER.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();

            if (RUN_HEADLESS.equals(TRUE)) {
                options.addArguments("headless");
            }

            if (MAXIMIZE_THE_WINDOW.equals(TRUE)) {
                options.addArguments("start-maximized");
            }

            driver = new EdgeDriver(options);
        } else{
            Logger.getAnonymousLogger().log(Level.INFO,"An unsupported browser argument was provided at run-time.");
        }


    }
}
