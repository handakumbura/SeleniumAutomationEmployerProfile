package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

/***
 * The objective of this test class is to demonstrate a few common page synchronization strategies.
 */

public class PageSynchronization extends TestBase {
private static final By DROPDOWN = By.xpath("//*[@id='dropdown']");

    @BeforeClass
    public static void setup() {
        instantiateDriver();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(Constants.DROPDOWN_PAGE_URL);
    }

    @Test
    public static void explicitWait() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(driver -> driver.findElement(DROPDOWN));
    }

    @Test
    public static void fluentWait() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(WebDriverException.class).pollingEvery(Duration.ofSeconds(60)).withTimeout(Duration.ofSeconds(60));

        WebElement e = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(DROPDOWN);
            }
        });
    }

    @Test
    public static void refreshBrowser() {
        driver.navigate().refresh();
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
