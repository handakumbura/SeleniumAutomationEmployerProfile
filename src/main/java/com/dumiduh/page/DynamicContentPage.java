package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class DynamicContentPage extends PageBase {
    private WebDriver driver;
    private By divContent = By.xpath("//*[@id='content' and contains(@class, 'large-10')]");
    private By divContentRows = By.xpath("//*[@id='content' and contains(@class, 'large-10')]/*[@class='row']");

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Lets you know if the dynamic content is available on the page.
     * @return The status.
     */
    public boolean isTheDynamicContentAvailable() {
        try {
            driver.findElements(divContentRows);
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    /***
     * Lets you know the number of content rows displayed on the page.
     * @return The number of rows.
     */
    public int numberOfRowsContentDisplayed() {
        return driver.findElements(divContentRows).size();
    }

}
