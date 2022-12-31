package com.dumiduh.function;

import com.dumiduh.page.SliderPage;
import org.openqa.selenium.chrome.ChromeDriver;

public class SliderPageFunctions {
    private ChromeDriver driver;
    private SliderPage sliderPage;

    public SliderPageFunctions(ChromeDriver driver) {
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
