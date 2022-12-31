package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends PageBase {
    private ChromeDriver driver;
    private By sldSlider = By.xpath("//*[@type='range']");
    private By spnRange = By.xpath("//*[@id='range']");

    public SliderPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void moveSlider(int value) {
        Actions actions = new Actions(driver);
        int size = driver.findElement(sldSlider).getSize().getWidth();
        actions.moveToElement(driver.findElement(sldSlider), size / value, 0).click().build().perform();
    }

    public String getSliderValue() {
        return driver.findElement(spnRange).getText();
    }


}
