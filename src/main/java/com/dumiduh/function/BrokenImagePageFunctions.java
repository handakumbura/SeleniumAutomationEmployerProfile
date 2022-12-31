package com.dumiduh.function;

import com.dumiduh.page.BrokenImagePage;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImagePageFunctions {
    private ChromeDriver driver;
    private BrokenImagePage brokenImagePage;

    public BrokenImagePageFunctions(ChromeDriver driver) {
        this.driver = driver;
        brokenImagePage = new BrokenImagePage(driver);
    }

    public int getStatusCodeOfImage(String img) {
        return brokenImagePage.getStatusCodeOfImage(img);
    }

}
