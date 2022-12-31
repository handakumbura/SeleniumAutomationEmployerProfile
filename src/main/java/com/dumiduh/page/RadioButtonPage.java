package com.dumiduh.page;

import io.github.handakumbura.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonPage extends PageBase {
    private final By RADIO_BUTTON_GROUP = By.xpath("//*[@name='software']");
    private ChromeDriver driver;
    private RadioButton radioButton;

    public RadioButtonPage(ChromeDriver driver) {
        this.driver = driver;
        driver.switchTo().frame("iframeResult");
        radioButton = new RadioButton(driver.findElements(RADIO_BUTTON_GROUP));
    }

    public void selectByValue(String value) {
        radioButton.clickByValue(value);
    }

    public String getValueOfTheSelectedOption() {
        //possible defect or limitation in the JavascriptExecutor.
        String result = (String) ((JavascriptExecutor) driver).executeScript("$0.getAttribute('value')");
        return result;
    }


}
