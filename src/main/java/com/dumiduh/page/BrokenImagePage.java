package com.dumiduh.page;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenImagePage extends PageBase {
    private String urlBase = "https://the-internet.herokuapp.com/%s";

    public BrokenImagePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public int getStatusCodeOfImage(String img) {
        HttpURLConnection cn = null;
        try {
            cn = (HttpURLConnection) new URL(String.format(urlBase, img)).openConnection();
            cn.setRequestMethod("HEAD");
            cn.connect();
            return cn.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
