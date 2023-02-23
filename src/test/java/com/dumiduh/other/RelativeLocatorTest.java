package com.dumiduh.other;

import com.dumiduh.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.DROPDOWN_PAGE_URL;

public class RelativeLocatorTest extends TestBase {

    @Test
    public static void testOne() {
        instantiateDriver();
        driver.get("https://omayo.blogspot.com/");
        driver.findElement(By.xpath("//*[@name='q']"))
                .sendKeys("test");
        driver.findElement(RelativeLocator.with(By.xpath("//*[@class='gsc-search-button']"))
                        .toRightOf(By.xpath("//*[@name='q']")))
                .click();
    }

}

