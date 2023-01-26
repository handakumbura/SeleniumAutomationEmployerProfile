package com.dumiduh.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.dumiduh.constants.Constants.*;

public class AbstractionBase {
    public AbstractionBase() {
        configureLogger();
    }    protected static Logger logger = logger = Logger.getLogger(AbstractionBase.class.getName());

    /***
     *  A generic explicit wait.
     * @param driver
     * @param element
     * @return The web element being wait on.
     * @throws TimeoutException
     */
    protected WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) throws TimeoutException {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }

    /***
     * A predefined static wait.
     */
    protected void sleep() {
        try {
            logger.log(Level.WARNING, "The execution of the test script is put to sleep for " + DEFAULT_SLEEP_TIME_IN_MILLISECONDS);
            Thread.sleep(DEFAULT_SLEEP_TIME_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void configureLogger() {
        logger.setLevel(LOG_LEVEL);

        try {
            Handler fileHandler = new FileHandler("src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "dumiduh" + File.separator + "resources" + File.separator + "logs" + File.separator + "runtime.log", 10000, 1);
            fileHandler.setFormatter(new MyFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
