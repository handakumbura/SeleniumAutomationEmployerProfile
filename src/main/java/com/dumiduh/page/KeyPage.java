package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPage extends PageBase {
    private WebDriver driver;
    private By txtInput = By.xpath("//*[@id='target']");
    private By txtResult = By.xpath("//*[@id=\'result\']");

    public KeyPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Key sequence to be passed into the text box.
     * @param sequence Key sequence.
     */
    public void sendKeys(CharSequence sequence) {
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(txtInput), sequence).build().perform();
    }

    /***
     * Lets you know the value of the result textbox.
     * @return
     */
    public String getResult(){
        return driver.findElement(txtResult).getText();
    }

}
