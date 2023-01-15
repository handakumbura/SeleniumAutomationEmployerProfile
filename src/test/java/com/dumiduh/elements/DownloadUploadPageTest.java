package com.dumiduh.elements;


import com.dumiduh.utils.FileUtil;
import com.dumiduh.utils.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.dumiduh.constants.Constants.DOWLOAD_ASSET;
import static com.dumiduh.constants.Constants.UPLOAD_ASSET;

/**
 * The objective of this class is to demonstrate how downloads and uploads may be completed.
 */

public class DownloadUploadPageTest extends TestBase {
    private static final By UPLOAD = By.xpath("//*[@id='file-upload']");
    private static final By SUBMIT = By.xpath("//*[@id='file-submit']");
    private static final String DOWNLOAD_FOLDER_PATH_VALUE = "C:\\Users\\THINKPAD\\AutomationTemp";
    private static final String DOWNLOAD_FOLDER_PATH_KEY = "download.default_directory";
    private static final String DOWNLOAD_ASSET_NAME = "\\apple.jpeg";

    private static final By UPLOAD_SUCCESS_MESSAGE = By.xpath("//*[text()='File Uploaded!']");

    private static final String UPLOAD_ASSET_FULLY_QUALIFIED_NAME = "C:\\Users\\THINKPAD\\Documents\\Dumidu Handakumbura Resume.pdf";

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put(DOWNLOAD_FOLDER_PATH_KEY, DOWNLOAD_FOLDER_PATH_VALUE);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @Test
    public static void downloadTest() {
        driver.get(DOWLOAD_ASSET);
        FileUtil.isFileAvailableInTheGivenLocation(DOWNLOAD_FOLDER_PATH_KEY + DOWNLOAD_ASSET_NAME);
    }

    @Test
    public static void uploadTest() {
        driver.get(UPLOAD_ASSET);
        driver.findElement(UPLOAD).sendKeys(UPLOAD_ASSET_FULLY_QUALIFIED_NAME);
        driver.findElement(SUBMIT).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(driver.findElement(UPLOAD_SUCCESS_MESSAGE)));
    }

    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
