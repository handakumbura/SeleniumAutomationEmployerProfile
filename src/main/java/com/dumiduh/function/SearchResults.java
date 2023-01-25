package com.dumiduh.function;

import com.dumiduh.page.SearchResultsPage;
import org.openqa.selenium.WebDriver;

public class SearchResults {
    private WebDriver driver;
    private SearchResultsPage searchResultsPage;

    public SearchResults(WebDriver driver) {
        this.driver = driver;
        searchResultsPage = new SearchResultsPage(driver);
    }

    public void filterByFourStarReviews() {
        searchResultsPage.filterByFourStarReviews();
    }

    public void filterByLanguage(String language) {
        searchResultsPage.filterByLanguage(language);
    }

    public void selectProductByIndex(int index) {
        searchResultsPage.selectProductByIndex(index);
    }

    public String getProductName(int index) {
        return searchResultsPage.getProductName(index);
    }


}
