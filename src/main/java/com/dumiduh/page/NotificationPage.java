package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationPage extends PageBase {
    private ChromeDriver driver;
    private By lnkClickHere = By.xpath("//a[text()='Click here']");
    private By lblNotification = By.xpath("//div[@class='flash notice']");

    public NotificationPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void clickClickHere() {
        driver.findElement(lnkClickHere).click();
    }

    public String readNotificationMessage() {
        return driver.findElement(lblNotification).getText();
    }

}
