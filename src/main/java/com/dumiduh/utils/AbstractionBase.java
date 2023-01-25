package com.dumiduh.utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.dumiduh.constants.Constants.DEFAULT_SLEEP_TIME_IN_MILLISECONDS;
import static com.dumiduh.constants.Constants.DEFAULT_WAIT_TIME_IN_SECONDS;

public class AbstractionBase {

    protected void scrollToElement(){

    }

    protected WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element) throws TimeoutException {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME_IN_SECONDS)).until(ExpectedConditions.visibilityOf(element));
    }

    protected void sleep(){
        try {
            Thread.sleep(DEFAULT_SLEEP_TIME_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //protected WebElement waitFor
}
