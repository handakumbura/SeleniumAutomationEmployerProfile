package com.dumiduh.function;

import com.dumiduh.page.KeyPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPageFunctions {
    private KeyPage keyPage;
    private ChromeDriver driver;

    public KeyPageFunctions(ChromeDriver driver) {
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
