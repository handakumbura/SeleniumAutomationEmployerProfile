package com.dumiduh.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomBy extends By {
    private String searchTerm;
    private final String XPATH = "//*[contains(text(),'%s')]";

    public static By containsText(String searchTerm) {
        return new CustomBy(searchTerm);
    }

    private CustomBy(String value) {
        this.searchTerm = value;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.xpath(String.format(XPATH, searchTerm)));
    }
}
