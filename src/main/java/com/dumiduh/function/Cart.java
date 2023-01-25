package com.dumiduh.function;

import com.dumiduh.page.CartPage;
import org.openqa.selenium.WebDriver;

public class Cart {
    private WebDriver driver;
    private CartPage cartPage;

    public Cart(WebDriver driver) {
        this.driver = driver;
        cartPage = new CartPage(driver);
    }

    public void clickClearCart() {
        cartPage.clickClearCart();
    }

    public boolean isClearCartSuccessMessageDisplayed(String expectedMessage) {
        return cartPage.isCartClearSuccessMessageDisplayed(expectedMessage);
    }

    public double getSubTotal() {
        return cartPage.getSubTotal();
    }

    public String getTheProductName() {
        return cartPage.getTheProductName();
    }

    public int getProductQuantity() {
        return cartPage.getProductQuantity();
    }

}
