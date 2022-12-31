package com.dumiduh.function;

import com.dumiduh.page.NotificationPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class NotificationPageFunctions {
    private NotificationPage notificationPage;
    private ChromeDriver driver;

    public NotificationPageFunctions(ChromeDriver driver) {
        this.driver = driver;
        notificationPage = new NotificationPage(driver);
    }

    /***
     * Clicks on the link that displays the notification.
     */
    public void displayTheNotification() {
        notificationPage.clickClickHere();
    }

    /***
     * Reads the content of the notification.
     * @return The notification content.
     */
    public String readTheDisplayedNotification() {
        return notificationPage.readNotificationMessage();
    }


}
