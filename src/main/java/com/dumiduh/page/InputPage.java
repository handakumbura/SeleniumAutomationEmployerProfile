package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputPage extends PageBase {
    private ChromeDriver driver;
    private By txtInput = By.xpath("//*[@type='number']");

    public InputPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void setText(int value) {
        driver.findElement(txtInput).sendKeys(Integer.toString(value));
    }

}
