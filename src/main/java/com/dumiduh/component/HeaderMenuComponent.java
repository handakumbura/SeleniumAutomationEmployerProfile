package com.dumiduh.component;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HeaderMenuComponent extends AbstractionBase {
    private WebDriver driver;
    private Select select;
    private By selectCategory = By.xpath("//select[@id='searchDropdownBox']");
    private By inputSearchTerm = By.xpath("//input[@id='twotabsearchtextbox' or @placeholder='Search Amazon']");

    private By btnGoToCart = By.xpath("//span[@id='nav-cart-count']");

    public HeaderMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAValueFromTheSelectSearchCategoryDropdown(String category) {
        try{
            select = new Select(waitForVisibilityOfElement(driver, driver.findElement(selectCategory)));
            select.selectByVisibleText(category);
        } catch (TimeoutException | NoSuchElementException e) {
            e.printStackTrace();
        }

    }

    public void typeInTheProductSearchTermAndPressEnter(String productSearchTerm) {
        driver.findElement(inputSearchTerm).sendKeys(productSearchTerm + Keys.ENTER);
    }

    public void clickGoToCart() {
        driver.findElement(btnGoToCart).click();
    }
}
