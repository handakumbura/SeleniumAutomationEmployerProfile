package com.dumiduh.function;

import com.dumiduh.page.DynamicLoadPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPageFunctions {
    private DynamicLoadPage dynamicLoadPage;
    private ChromeDriver driver;

    public DynamicPageFunctions(ChromeDriver driver) {
        this.driver = driver;
        dynamicLoadPage = new DynamicLoadPage(driver);
    }

    public void waitForTheProgressBarToDisappear() {
        dynamicLoadPage.waitTillTheProgressBarDisappears();
    }

    public String getTheFinalText() {
        return dynamicLoadPage.getTheFinishText();
    }

    public void clickTheStartButton() {
        dynamicLoadPage.clickStart();
    }


}
