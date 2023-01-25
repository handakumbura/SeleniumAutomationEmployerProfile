package com.dumiduh.component;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HeaderMenuComponent extends AbstractionBase {
    private WebDriver driver;
    private Select select;
    private By selectCategory = By.xpath("//select[@id='searchDropdownBox' or @aria-describedby='searchDropdownDescription']");
    private By inputSearchTerm = By.xpath("//input[@id='twotabsearchtextbox' or @placeholder='Search Amazon']");

    private By btnGoToCart = By.xpath("//span[@id='nav-cart-count']");

    public HeaderMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAValueFromTheSelectSearchCategoryDropdown(String category) {
        select = new Select(driver.findElement(selectCategory));
        select.selectByVisibleText(category);
    }

    public void typeInTheProductSearchTermAndPressEnter(String productSearchTerm) {
        driver.findElement(inputSearchTerm).sendKeys(productSearchTerm + Keys.ENTER);
    }

    public void clickGoToCart() {
        driver.findElement(btnGoToCart).click();
    }
}
