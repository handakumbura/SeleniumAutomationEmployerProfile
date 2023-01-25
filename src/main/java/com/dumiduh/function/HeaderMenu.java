package com.dumiduh.function;

import com.dumiduh.component.HeaderMenuComponent;
import org.openqa.selenium.WebDriver;

public class HeaderMenu {
    private WebDriver driver;
    private HeaderMenuComponent headerMenuComponent;

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        headerMenuComponent = new HeaderMenuComponent(driver);
    }

    public void selectAValueFromTheSelectSearchCategoryDropdown(String category) {
        headerMenuComponent.selectAValueFromTheSelectSearchCategoryDropdown(category);
    }

    public void typeInTheProductSearchTermAndPressEnter(String productSearchTerm) {
        headerMenuComponent.typeInTheProductSearchTermAndPressEnter(productSearchTerm);
    }

    public void clickGoToCart() {
        headerMenuComponent.clickGoToCart();
    }

}
