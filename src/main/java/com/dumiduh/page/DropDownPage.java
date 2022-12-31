package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends PageBase {
    private By drpDropDown = By.xpath("//*[@id='dropdown']");
    private Select select;

    public DropDownPage(ChromeDriver driver) {
        this.driver = driver;
        select = new Select(driver.findElement(drpDropDown));
    }

    public void selectValueFromDropDown(String value) {
        select.selectByVisibleText(value);
    }

    public boolean isTheGivenValueSelected(String value) {
        return select.getFirstSelectedOption().getText().equals(value);
    }
}
