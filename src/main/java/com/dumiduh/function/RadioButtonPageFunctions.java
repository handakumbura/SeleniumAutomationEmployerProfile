package com.dumiduh.function;

import com.dumiduh.page.RadioButtonPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonPageFunctions {
    private RadioButtonPage radioButtonPage;
    private ChromeDriver driver;

    public RadioButtonPageFunctions(ChromeDriver driver) {
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
