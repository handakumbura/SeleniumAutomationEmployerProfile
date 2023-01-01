package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationPage extends PageBase {
    private WebDriver driver;
    private By lnkClickHere = By.xpath("//a[text()='Click here']");
    private By lblNotification = By.xpath("//div[@class='flash notice']");

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Clicks the Click Her link.
     */
    public void clickClickHere() {
        driver.findElement(lnkClickHere).click();
    }

    /***
     * Lets you know the value of the notification message.
     * @return
     */
    public String readNotificationMessage() {
        return driver.findElement(lblNotification).getText();
    }

}
