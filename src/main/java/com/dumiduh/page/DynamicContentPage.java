package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicContentPage extends PageBase {
    private ChromeDriver driver;
    private By divContent = By.xpath("//*[@id='content' and contains(@class, 'large-10')]");
    private By divContentRows = By.xpath("//*[@id='content' and contains(@class, 'large-10')]/*[@class='row']");

    public DynamicContentPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public boolean isTheDynamicContentAvailable() {
        try {
            driver.findElements(divContentRows);
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    public int numberOfRowsContentDisplayed() {
        return driver.findElements(divContentRows).size();
    }

}
