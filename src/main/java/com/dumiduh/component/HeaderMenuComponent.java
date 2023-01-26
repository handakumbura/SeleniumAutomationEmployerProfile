package com.dumiduh.component;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.logging.Level;

public class HeaderMenuComponent extends AbstractionBase {
    private final WebDriver driver;
    private final By selectCategory = By.xpath("//select[@id='searchDropdownBox']");
    private final By inputSearchTerm = By.xpath("//input[@id='twotabsearchtextbox' or @placeholder='Search Amazon']");

    private final By btnGoToCart = By.xpath("//span[@id='nav-cart-count']");

    /***
     * The structural abstraction layer object for the Header component.
     * @param driver
     */
    public HeaderMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Sets the value of the search category dropdown.
     * @param category The visible test of the dropdown value to be selected.
     */
    public void selectAValueFromTheSelectSearchCategoryDropdown(String category) {
        try {
            Select select = new Select(waitForVisibilityOfElement(driver, driver.findElement(selectCategory)));
            select.selectByVisibleText(category);
        } catch (TimeoutException | NoSuchElementException e) {
           logger.log(Level.SEVERE,e.getMessage());
        }

    }

    /***
     * Initiates a search term.
     * @param productSearchTerm the term to be searched.
     */
    public void typeInTheProductSearchTermAndPressEnter(String productSearchTerm) {
        driver.findElement(inputSearchTerm).sendKeys(productSearchTerm + Keys.ENTER);
    }

    /***
     * Clicks on 'go to cart'.
     */
    public void clickGoToCart() {
        driver.findElement(btnGoToCart).click();
    }
}
