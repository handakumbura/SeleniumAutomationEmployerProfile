package com.dumiduh.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends PageBase {
    private WebDriver driver;
    private By sldSlider = By.xpath("//*[@type='range']");
    private By spnRange = By.xpath("//*[@id='range']");

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    /***
     * Moves the slider needle based on the value argument.
     * @param value The value
     */
    public void moveSlider(int value) {
        Actions actions = new Actions(driver);
        int size = driver.findElement(sldSlider).getSize().getWidth();
        actions.moveToElement(driver.findElement(sldSlider), size / value, 0).click().build().perform();
    }

    /***
     * Lets you know the slider value.
     * @return The value.
     */
    public String getSliderValue() {
        return driver.findElement(spnRange).getText();
    }


}
