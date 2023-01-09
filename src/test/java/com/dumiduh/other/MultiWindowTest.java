package com.dumiduh.other;

import com.dumiduh.constants.Constants;
import com.dumiduh.utils.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MultiWindowTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(Constants.MULTI_WINDOW);
    }

    @Test
    public static void multiWindowTest() {
        Logger.getAnonymousLogger().log(Level.INFO, String.valueOf(driver.getWindowHandles().size()));
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //A new tab has been opened.
        Logger.getAnonymousLogger().log(Level.INFO, String.valueOf(driver.getWindowHandles().size()));

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterator = windows.iterator();

        while (iterator.hasNext()) {
            String window = iterator.next();

            //switching to the newly opened tab.
            if (!window.equals(driver.getWindowHandle())) {
                driver.switchTo().window(window);
            }
        }

        Assert.assertEquals(driver.findElement(By.xpath("//h3[text()='New Window']")).getText(),"New Window");

    }


    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
