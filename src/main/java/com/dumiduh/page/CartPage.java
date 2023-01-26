package com.dumiduh.page;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends AbstractionBase {
    private WebDriver driver;
    private By productName = By.xpath("//div[@class='sc-item-content-group']//descendant::span[contains(@class,'sc-grid-item-product-title')]");
    private By productQuantity = By.xpath("//span[@id='sc-subtotal-label-buybox']");
    private By subTotal = By.xpath("//span[@id='sc-subtotal-amount-buybox']");
    private By lnkDelete = By.xpath("//*[@value='Delete']");
    private String spanCartClearSuccessMessage = "//*[contains(text(),'%s')]";

    /***
     * The page abstraction for the cart screen.
     * @param driver
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Returns the sub total.
     * @return
     */
    public double getSubTotal() {
        return Double.parseDouble(waitForVisibilityOfElement(driver, driver.findElement(subTotal)).getText().split("\\$")[1]);
    }

    /***
     * Clears the cart.
     */
    public void clickClearCart() {
        driver.findElement(lnkDelete).click();
    }

    /***
     * Checks to see if the clear cart success message is displayed.
     * @param expectedMessage
     * @return state of the message element visibility.
     */
    public boolean isCartClearSuccessMessageDisplayed(String expectedMessage) {
        sleep();
        return driver.findElement(By.xpath(String.format(spanCartClearSuccessMessage, expectedMessage))).isDisplayed();
    }

    /***
     * Returns the product name.
     * @return the product name.
     */
    public String getTheProductName() {
        return driver.findElement(productName).getText();
    }

    /***
     * Returns the product quantity.
     * @return the product quantity.
     */
    public int getProductQuantity() {
        return Integer.parseInt(driver.findElement(productQuantity).getText().split("\\(")[1].substring(0, 1));
    }
}
