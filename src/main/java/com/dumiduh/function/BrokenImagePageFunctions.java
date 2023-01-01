package com.dumiduh.function;

import com.dumiduh.page.BrokenImagePage;
import org.openqa.selenium.WebDriver;

public class BrokenImagePageFunctions {
    private WebDriver driver;
    private BrokenImagePage brokenImagePage;

    public BrokenImagePageFunctions(WebDriver driver) {
        this.driver = driver;
        brokenImagePage = new BrokenImagePage(driver);
    }

    public int getStatusCodeOfImage(String img) {
        return brokenImagePage.getStatusCodeOfImage(img);
    }

}
