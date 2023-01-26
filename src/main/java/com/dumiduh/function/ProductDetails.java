package com.dumiduh.function;

import com.dumiduh.page.ProductDetailsPage;
import org.openqa.selenium.WebDriver;

public class ProductDetails {
    private ProductDetailsPage productDetailsPage;

    public ProductDetails(WebDriver driver) {
        productDetailsPage = new ProductDetailsPage(driver);
    }

    public double getUnitPrice() {
        return productDetailsPage.getUnitPrice();
    }

    public String getProductName() {
        return productDetailsPage.getProductName();
    }

    public void setQuantity(int quantity) {
        productDetailsPage.setQuantity(quantity);
    }

    public void clickAddToCart() {
        productDetailsPage.clickAddToCart();
    }
}
