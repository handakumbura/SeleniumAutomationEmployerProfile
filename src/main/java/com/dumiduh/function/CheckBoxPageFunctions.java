package com.dumiduh.function;

import com.dumiduh.page.CheckBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxPageFunctions {
    private CheckBoxPage checkBoxPage;
    private ChromeDriver driver;

    public CheckBoxPageFunctions(ChromeDriver driver) {
        this.driver = driver;
        checkBoxPage = new CheckBoxPage(driver);
    }

    /***
     * Checks The checkbox based on the check box number provided.
     * @param value the checkbox number
     */
    public void checkCheckBoxValue(String value) {
        checkBoxPage.checkCheckBoxValue(value);
    }

    /***
     * Checks to see if the checkbox is checked.
     * @param value the checkbox number
     * @return whether the checkbox is checked or not.
     */
    public boolean isTheGivenCheckBoxChecked(String value) {
       return checkBoxPage.isTheGivenCheckBoxChecked(value);
    }

}
