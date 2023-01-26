package com.dumiduh.page;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends AbstractionBase {
    private WebDriver driver;
    private final By spanUnitPriceVersionOne = By.xpath("//*[@id='rental-header-price']//descendant::span");
    private final By spanUnitPriceVersionTwo = By.xpath("//*[@id='corePrice_feature_div']//descendant::span");
    private final By spanUnitPriceVersionThree = By.xpath("//*[@id='kindle-price']");

    private final By spanUnitPriceVersionFour = By.xpath("//*[@id='price']");

    private By spanProductName = By.xpath("//*[@id='productTitle']");
    private By selectQuantity = By.xpath("//select[@id='quantity']");
    private By btnAddToCart = By.xpath("//input[@id='add-to-cart-button']");

    /***
     * The page abstraction for the product details screen.
     * @param driver
     */
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Returns the unit price.
     * @return The unit price.
     */
    public double getUnitPrice() {
        WebElement unitPrice = driver.findElement(new ByAll(spanUnitPriceVersionOne, spanUnitPriceVersionTwo, spanUnitPriceVersionThree, spanUnitPriceVersionFour));
        return Double.parseDouble(waitForVisibilityOfElement(driver, unitPrice).getText().split("\\$")[1]);
    }

    /***
     * Returns the product name.
     * @return The product name.
     */
    public String getProductName() {
        return waitForVisibilityOfElement(driver, driver.findElement(spanProductName)).getText();
    }

    /***
     * Returns the quantity.
     * @param quantity The quantity.
     */
    public void setQuantity(int quantity) {
        Select select = new Select(driver.findElement(selectQuantity));
        select.selectByVisibleText(Integer.toString(quantity));
    }

    /***
     * Adds item to cart.
     */
    public void clickAddToCart() {
        driver.findElement(btnAddToCart).click();
    }
}
