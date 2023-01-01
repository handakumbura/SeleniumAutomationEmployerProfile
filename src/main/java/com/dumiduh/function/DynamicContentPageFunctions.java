package com.dumiduh.function;

import com.dumiduh.page.DynamicContentPage;
import org.openqa.selenium.WebDriver;

public class DynamicContentPageFunctions {
    private DynamicContentPage dynamicContentPage;
    private WebDriver driver;

    public DynamicContentPageFunctions(WebDriver driver) {
        this.driver = driver;
        dynamicContentPage = new DynamicContentPage(driver);
    }

    /***
     * Checks to see if the dynamic content is available on the page.
     * @return Whether the content is available.
     */
    public boolean isTheDynamicContentAvailable() {
        return dynamicContentPage.isTheDynamicContentAvailable();
    }

    /***
     * Returns the number of rows of content available.
     * @return The number of rows available in the content.
     */
    public int numberOfRowsContentDisplayed() {
        return dynamicContentPage.numberOfRowsContentDisplayed();
    }


}
