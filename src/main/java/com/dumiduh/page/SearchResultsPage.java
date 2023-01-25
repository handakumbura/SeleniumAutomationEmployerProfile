package com.dumiduh.page;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

public class SearchResultsPage extends AbstractionBase {
    private WebDriver driver;
    private By spanFilterByFourStarReviews = By.xpath("//*[@class='a-icon a-icon-star-medium a-star-medium-4' or contains(text(), '4 Star')]");
    private By spanFourStarFilterConformation = By.xpath("//*[@aria-label='4 Stars & Up']//descendant::span[contains(@class,'bold')]");
    private String spanFilterByLanguageTemplate = "//span[text()='Language']//following::span[text()='%s' and @class='a-size-base a-color-base%s']";
    private String spanProductNameGeneric = "(//*[@class='a-section'])[%s]//descendant::span[@class='a-size-medium a-color-base a-text-normal']";
    private String spanProductNameGenericAlt = "(//*[@class='a-section a-spacing-base'])[%s]//descendant::span[@class='a-size-base-plus a-color-base a-text-normal']";
    private WebElement productName;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterByFourStarReviews() {
        driver.findElement(spanFilterByFourStarReviews).click();
        waitForVisibilityOfElement(driver, driver.findElement(spanFourStarFilterConformation)); // waiting until the UI confirmation of the filter application.
    }

    public void filterByLanguage(String language) {
        waitForVisibilityOfElement(driver, driver.findElement(By.xpath(String.format(spanFilterByLanguageTemplate, language, "")))).click();
        sleep();
        waitForVisibilityOfElement(driver, driver.findElement(By.xpath(String.format(spanFilterByLanguageTemplate, language, " a-text-bold"))));
    }

    public void selectProductByIndex(int index) {
        productName = driver.findElement(new ByAll(By.xpath(String.format(spanProductNameGeneric, index)), By.xpath(String.format(spanProductNameGenericAlt, index))));
        waitForVisibilityOfElement(driver, productName).click();
    }

    public String getProductName(int index) {
        productName = driver.findElement(new ByAll(By.xpath(String.format(spanProductNameGeneric, index)), By.xpath(String.format(spanProductNameGenericAlt, index))));
        return waitForVisibilityOfElement(driver, productName).getText();
    }
}
