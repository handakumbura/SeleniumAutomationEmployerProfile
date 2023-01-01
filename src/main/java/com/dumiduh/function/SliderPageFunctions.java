package com.dumiduh.function;

import com.dumiduh.page.SliderPage;
import org.openqa.selenium.WebDriver;

public class SliderPageFunctions {
    private WebDriver driver;
    private SliderPage sliderPage;

    public SliderPageFunctions(WebDriver driver) {
        this.driver = driver;
        sliderPage = new SliderPage(driver);
    }

    public void moveSlider(int value) {
        sliderPage.moveSlider(value);
    }

    public String getSliderValue() {
        return sliderPage.getSliderValue();
    }

}
