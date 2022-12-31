package com.dumiduh.other;

import com.dumiduh.utils.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.dumiduh.constants.Constants.LOCAL_STORAGE;

/***
 * Object of this test class is to demonstrate how browser local storage can be handled.
 */
public class LocalStorage extends TestBase {
    private static final By INPUT_LIST = By.xpath("//*[@class=\'new-todo\']");
    private static final String JS_SNIPPET_FOR_PARSED_DATA = "return JSON.parse(localStorage.getItem('todos-eviltester'))";

    @BeforeClass
    public static void setup() {
        instantiateChromeDriver();
        driver.get(LOCAL_STORAGE);
    }

    @Test
    public static void localStorage() {
        driver.findElement(INPUT_LIST).sendKeys("dumidu" + Keys.ENTER);
        List<Map<String, Object>> values =
                (List<Map<String, Object>>)
                        ((JavascriptExecutor) driver).
                                executeScript(JS_SNIPPET_FOR_PARSED_DATA);
        Assert.assertTrue(values.get(0).get("title").equals("dumidu"));
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
