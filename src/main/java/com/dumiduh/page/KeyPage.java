package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPage extends PageBase {
    private ChromeDriver driver;
    private By txtInput = By.xpath("//*[@id='target']");
    private By txtResult = By.xpath("//*[@id=\'result\']");

    public KeyPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void sendKeys(CharSequence sequence) {
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(txtInput), sequence).build().perform();
    }

    public String getResult(){
        return driver.findElement(txtResult).getText();
    }

}
