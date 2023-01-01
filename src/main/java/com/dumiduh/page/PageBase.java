package com.dumiduh.page;

import org.openqa.selenium.WebDriver;

/***
 * Place for page layer common utility methods.
 */
public class PageBase {
    protected WebDriver driver;
    public void waitForPredefinedDuration(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
