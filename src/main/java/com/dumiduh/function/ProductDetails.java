package com.dumiduh.function;

import com.dumiduh.page.ProductDetailsPage;
import org.openqa.selenium.WebDriver;

public class ProductDetails {
    private WebDriver driver;
    private ProductDetailsPage productDetails;

    public ProductDetails(WebDriver driver) {
        this.driver = driver;
        productDetails = new ProductDetailsPage(driver);
    }

    public double getUnitPrice() {
        return productDetails.getUnitPrice();
    }

    public String getProductName() {
        return productDetails.getProductName();
    }

    public void setQuantity(int quantity) {
        productDetails.setQuantity(quantity);
    }

    public void clickAddToCart() {
        productDetails.clickAddToCart();
    }
}
