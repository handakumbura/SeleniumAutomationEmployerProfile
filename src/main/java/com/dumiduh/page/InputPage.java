package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputPage extends PageBase {
    private WebDriver driver;
    private By txtInput = By.xpath("//*[@type='number']");

    public InputPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Sets the text.
     * @param value The text to be set.
     */
    public void setText(int value) {
        driver.findElement(txtInput).sendKeys(Integer.toString(value));
    }

}
