package com.dumiduh.function;

import com.dumiduh.page.KeyPage;
import org.openqa.selenium.WebDriver;

public class KeyPageFunctions {
    private KeyPage keyPage;
    private WebDriver driver;

    public KeyPageFunctions(WebDriver driver) {
        this.driver = driver;
        keyPage = new KeyPage(driver);
    }


    public void sendKey(CharSequence sequence) {
        keyPage.sendKeys(sequence);
    }

    public String getResult(){
        return keyPage.getResult();
    }


}
