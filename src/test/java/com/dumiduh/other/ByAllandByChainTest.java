package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/***
 *  The objective of this test class is to demonstrate the use of selenium util functions ByAll, By Chained and Chained Expected conditions.
 */
public class ByAllandByChainTest extends TestBase {
    private static final By START_BUTTON_BY_XPATH = By.xpath("//*[@id='start']//button");
    private static final By START_BUTTON_BY_ID = By.id("start");
    private static final By PROGRESS_BAR_BY_XPATH = By.xpath("//*[@id='loading']");
    private static final String ATTRIBUTE = "style";
    private static final String VALUE = "display: none;";
    private static final By START_BUTTON_BY_XPATH_ALT = By.xpath("//button");
    private static final By HELLO_WORLD_BY_XPATH = By.xpath("//*[text()='Hello World!']");


    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(Constants.DYNAMIC_LOAD);
    }

    @Test()
    public static void byAll() {
        driver.findElement(new ByAll(START_BUTTON_BY_XPATH, START_BUTTON_BY_ID)).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.and(ExpectedConditions.attributeToBe(PROGRESS_BAR_BY_XPATH, ATTRIBUTE, VALUE), ExpectedConditions.visibilityOf(driver.findElement(HELLO_WORLD_BY_XPATH))));
    }

    @Test()
    public static void byChained() {
        driver.navigate().refresh();
        driver.findElement(new ByChained(START_BUTTON_BY_ID, START_BUTTON_BY_XPATH_ALT)).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.and(ExpectedConditions.attributeToBe(By.xpath("//*[@id='loading']"), "style", "display: none;"), ExpectedConditions.visibilityOf(driver.findElement(HELLO_WORLD_BY_XPATH))));
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
