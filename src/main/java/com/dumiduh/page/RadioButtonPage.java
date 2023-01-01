package com.dumiduh.page;

import io.github.handakumbura.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends PageBase {
    private final By RADIO_BUTTON_GROUP = By.xpath("//*[@name='software']");
    private WebDriver driver;
    private RadioButton radioButton;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        driver.switchTo().frame("iframeResult");
        radioButton = new RadioButton(driver.findElements(RADIO_BUTTON_GROUP));
    }

    /***
     * Selects radio button by value.
     * @param value
     */
    public void selectByValue(String value) {
        radioButton.clickByValue(value);
    }

    /***
     * Lets you know the value of the selected radio button.
     * @return The value.
     */
    public String getValueOfTheSelectedOption() {
        //possible defect or limitation in the JavascriptExecutor.
        String result = (String) ((JavascriptExecutor) driver).executeScript("$0.getAttribute('value')");
        return result;
    }


}
