package com.dumiduh.utils;

import com.dumiduh.models.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.dumiduh.constants.Constants.*;

public class TestBase {
    protected static WebDriver driver;
    protected static TestData data;
    protected static Logger logger;

    public TestBase() {
        logger = Logger.getLogger(TestBase.class.getName());
        configureLogger();
    }

    protected static void instantiateDriver() {

        try {
            if (BROWSER.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                if (RUN_HEADLESS.equals(TRUE)) {
                    options.addArguments("headless");
                }

                if (RUN_HEADLESS.equals(FALSE) && MAXIMIZE_THE_WINDOW.equals(TRUE)) {
                    options.addArguments("start-maximized");
                }

                driver = new ChromeDriver(options);
            } else if (BROWSER.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();

                if (RUN_HEADLESS.equals(TRUE)) {
                    options.addArguments("headless");
                }

                if (RUN_HEADLESS.equals(FALSE) && MAXIMIZE_THE_WINDOW.equals(TRUE)) {
                    options.addArguments("start-maximized");
                }

                driver = new EdgeDriver(options);
            } else {
                Logger.getAnonymousLogger().log(Level.INFO, "An unsupported browser argument was provided at run-time.");
            }
        } catch (SessionNotCreatedException e) {
            //todo
        }

    }

    private void configureLogger() {
        logger.setLevel(Level.INFO);

        try {
            Handler fileHandler = new FileHandler("src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "dumiduh" + File.separator + "resources" + File.separator + "logs" + File.separator + "runtime.log", 10000, 1);
            fileHandler.setFormatter(new MyFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
