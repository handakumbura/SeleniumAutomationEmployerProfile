package com.dumiduh.page;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends AbstractionBase {
    private WebDriver driver;
    private By spanFilterByFourStarReviews = By.xpath("//*[@class='a-icon a-icon-star-medium a-star-medium-4' or contains(text(), '4 Star')]");
    private String spanFilterByLanguageTemplate = "//span[text()='Language']//following::span[text()='%s' and contains(@class, 'a-size-base')]";

    private String spanProductNameGeneric = "(//*[@class='a-section'])[%s]//descendant::span[@class='a-size-medium a-color-base a-text-normal']";

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterByFourStarReviews() {
        driver.findElement(spanFilterByFourStarReviews).click();
    }

    public void filterByLanguage(String language) {
        driver.findElement(By.xpath(String.format(spanFilterByLanguageTemplate, language))).click();
    }

    public void selectProductByIndex(int index) {
        driver.findElement(By.xpath(String.format(spanProductNameGeneric, index))).click();
    }

    public String getProductName(int index) {
        return driver.findElement(By.xpath(String.format(spanProductNameGeneric, index))).getText();
    }
}
