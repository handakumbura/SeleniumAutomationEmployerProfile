package com.dumiduh.function;

import com.dumiduh.page.DynamicLoadPage;
import org.openqa.selenium.WebDriver;

public class DynamicPageFunctions {
    private DynamicLoadPage dynamicLoadPage;
    private WebDriver driver;

    public DynamicPageFunctions(WebDriver driver) {
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
