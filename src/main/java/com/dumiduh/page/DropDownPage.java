package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends PageBase {
    private By drpDropDown = By.xpath("//*[@id='dropdown']");
    private Select select;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        select = new Select(driver.findElement(drpDropDown));
    }

    /***
     * Selects the value from the dropdown based on the visible text.
     * @param value The visible test of the dropdown value to be selected.
     */
    public void selectValueFromDropDown(String value) {
        select.selectByVisibleText(value);
    }

    /***
     * Lets you know if a given dropdown value has been selected.
     * @param value The expected value.
     * @return The status.
     */
    public boolean isTheGivenValueSelected(String value) {
        return select.getFirstSelectedOption().getText().equals(value);
    }
}
