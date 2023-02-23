package com.dumiduh.other;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.log.model.LogEntry;
import org.openqa.selenium.devtools.v108.log.Log;
import org.testng.annotations.Test;

public class CDPTest {

    @Test
    public static void testOne(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools dt = driver.getDevTools();
        dt.createSession();
        dt.send(Log.enable());
        dt.addListener(Log.entryAdded(), (LogEntry event) -> System.out.println(event.getText()));

        driver.get("https://the-internet.herokuapp.com/dropdown");
        dt.clearListeners();
        dt.disconnectSession();
    }
}
