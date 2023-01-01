package com.dumiduh.page;

import io.github.handakumbura.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class CheckBoxPage extends PageBase {
    private WebDriver driver;
    private String chkCheckBoxGeneric = "//input[@type='checkbox'][X]";
    private String chkCheckBoxCheckedAppend = "[@checked]";

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Toggles the checkbox by value.
     * @param value the value of the checkbox to be toggled.
     */
    public void checkCheckBoxValue(String value) {
        CheckBox checkBox = new CheckBox(driver.findElement(By.xpath(chkCheckBoxGeneric.replace("X", value))));
        checkBox.toggle();
    }

    /***
     * Lets you know if a given checkbox is toggled.
     * @param value the value of the checkbox being inquired.
     * @return The status of the checkbox.
     */
    public boolean isTheGivenCheckBoxChecked(String value) {
        try {
            driver.findElement(By.xpath(chkCheckBoxGeneric.replace("X", value) + chkCheckBoxCheckedAppend));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

}
