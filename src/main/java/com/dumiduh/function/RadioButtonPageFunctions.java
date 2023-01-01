package com.dumiduh.function;

import com.dumiduh.page.RadioButtonPage;
import org.openqa.selenium.WebDriver;

public class RadioButtonPageFunctions {
    private RadioButtonPage radioButtonPage;
    private WebDriver driver;

    public RadioButtonPageFunctions(WebDriver driver) {
        this.driver = driver;
        radioButtonPage = new RadioButtonPage(driver);
    }

    public void selectRadioButtonByValue(String value) {
        radioButtonPage.selectByValue(value);
    }

    public String getValueOfTheSelectedOption(){
        return radioButtonPage.getValueOfTheSelectedOption();
    }

}
