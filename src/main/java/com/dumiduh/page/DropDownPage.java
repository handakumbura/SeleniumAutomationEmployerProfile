package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage extends PageBase {
    private By drpDropDown = By.xpath("//*[@id='dropdown']");
    private By lblDropDownListHeading = By.xpath("//h3[text()='Dropdown List']");
    private Select select;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        select = new Select(driver.findElement(drpDropDown));
    }

    /***
     * Returns the display status of the dropdown heading.
     * @return Returns the display status of the dropdown heading.
     */
    public boolean isElementHeadingDisplayed() {
        return driver.findElement(lblDropDownListHeading)
                .isDisplayed();
    }


    /***
     * Returns the list of options in the dropdown.
     * @return Returns the list of options in the dropdown.
     */
    public List<String> getAllDropDownOptions() {
        return select.getOptions()
                .stream()
                .map(elems -> elems.getText())
                .collect(Collectors.toList());
    }

    /***
     * Returns the display status of the dropdown element.
     * @return Returns the display status of the dropdown element.
     */
    public boolean isTheDropDownDisplayed() {
        return driver.findElement(drpDropDown)
                .isDisplayed();
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
