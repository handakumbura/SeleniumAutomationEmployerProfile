package com.dumiduh.function;

import com.dumiduh.page.DropDownPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownPageFunctions {
    private DropDownPage dropDownPage;
    private ChromeDriver driver;

    public DropDownPageFunctions(ChromeDriver driver) {
        this.driver = driver;
        dropDownPage = new DropDownPage(driver);
    }

    /***
     * Selects the given value from the dropdown
     * @param value the dropdown value
     */
    public void selectValueFromDropDown(String value) {
        dropDownPage.selectValueFromDropDown(value);
    }

    /***
     * Checks to see if a given dropdown value has been selected.
     * @param value The dropdown value.
     * @return Whether the dropdown value has been selected
     */
    public boolean isTheGivenValueSelected(String value) {
        return dropDownPage.isTheGivenValueSelected(value);
    }


}
