package com.dumiduh.page;

import io.github.handakumbura.CheckBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPage extends PageBase {
    private ChromeDriver driver;
    private String chkCheckBoxGeneric = "//input[@type='checkbox'][X]";
    private String chkCheckBoxCheckedAppend = "[@checked]";

    public CheckBoxPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void checkCheckBoxValue(String value) {
        CheckBox checkBox = new CheckBox(driver.findElement(By.xpath(chkCheckBoxGeneric.replace("X", value))));
        checkBox.toggle();
    }

    public boolean isTheGivenCheckBoxChecked(String value) {
        try {
            driver.findElement(By.xpath(chkCheckBoxGeneric.replace("X", value) + chkCheckBoxCheckedAppend));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

}
