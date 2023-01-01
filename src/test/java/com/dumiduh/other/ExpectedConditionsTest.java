package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/***
 * The objective of this test to demonstrate the use of different expected conditions.
 */
public class ExpectedConditionsTest extends TestBase {
    private static final By START_BUTTON = By.xpath("//*[@id='start']//button");
    private static final By PROGRESS_BAR = By.xpath("//*[@id='loading']");
    private static final By HELLO_WORLD_TEXT = By.xpath("//*[text()='Hello World!']");
    private static final By HIDDEN_TEXT = By.xpath("//*[contains(text(),'Element on page that is hidden')]");

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.DYNAMIC_LOAD);
    }

    @Test(priority = 1)
    public static void sequentialExpectedConditions() {
        driver.findElement(START_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.attributeToBe(PROGRESS_BAR, "style", "display: none;"));
        WebElement e = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.findElement(HELLO_WORLD_TEXT)));
    }

    @Test(priority = 2)
    public static void expectedConditionsChain() {
        driver.navigate().refresh();
        driver.findElement(START_BUTTON).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.and(ExpectedConditions.attributeToBe(PROGRESS_BAR, "style", "display: none;"), ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Hello World!']")))));
    }

    @Test(priority = 3)
    public static void customExpectedCondition() {
        driver.navigate().refresh();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                waitForDescriptionText()
        );
    }

    private static ExpectedCondition<Boolean> waitForDescriptionText() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(HIDDEN_TEXT).isDisplayed();
            }
        };
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
