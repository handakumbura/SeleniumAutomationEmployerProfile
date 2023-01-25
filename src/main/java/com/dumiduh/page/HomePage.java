package com.dumiduh.page;

import com.dumiduh.utils.AbstractionBase;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractionBase {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

   public void getDefaultLanguage(){
        //todo
   }

   public void getDefaultLocation(){
        //todo
   }
}
