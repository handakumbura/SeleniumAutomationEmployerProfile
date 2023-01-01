package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class DynamicLoadPage extends PageBase {
    private WebDriver driver;
    private By btnStart = By.xpath("//*[@id='start']//button");
    private By divProgressBarDisplayFalse = By.xpath("//*[@id='loading' and contains(@style, 'display')]");
    private By divFinish = By.xpath("//*[@id='finish']");

    public DynamicLoadPage(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    /***
     * Waits till the progress bare disappears.
     */
    public void waitTillTheProgressBarDisappears() {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofSeconds(2)).ignoring(WebDriverException.class);

        wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                System.out.println("--------");
                return driver.findElement(divProgressBarDisplayFalse);

            }
        });
    }

    /***
     * Lets you know the finish text.
     * @return The actual value.
     */
    public String getTheFinishText() {
        return driver.findElement(divFinish).getText();
    }

    /***
     * Clicks the start button.
     */
    public void clickStart() {
        driver.findElement(btnStart).click();
    }


}
