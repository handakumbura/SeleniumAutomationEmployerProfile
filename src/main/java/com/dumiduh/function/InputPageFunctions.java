package com.dumiduh.function;

import com.dumiduh.page.InputPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputPageFunctions {
    private InputPage inputPage;
    private ChromeDriver driver;

    public InputPageFunctions(ChromeDriver driver) {
        this.driver = driver;
        inputPage = new InputPage(driver);
    }

    /***
     * Sets the text inside the input element.
     * @param value The value to be set inside the input element.
     */
    public void setText(int value) {
        inputPage.setText(value);
    }


}
