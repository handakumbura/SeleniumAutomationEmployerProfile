package com.dumiduh.function;

import com.dumiduh.page.TablePage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class TablePageFunctions {
    private TablePage tablePage;
    private WebDriver driver;

    public TablePageFunctions(WebDriver driver) {
        this.driver = driver;
        tablePage = new TablePage(driver);
    }

    public List<String> getColumnHeaders() {
        return tablePage.getColumnHeaders();
    }

    public List<String> getValuesForAGivenRow(int row) {
        return tablePage.getValuesForAGivenRow(row);
    }

    public String getValuesForAGivenRowAndColumn(int row, int column) {
        return tablePage.getValuesForAGivenRowAndColumn(row, column);
    }

    public Map<Integer, List<String>> getAllValues() {
        return tablePage.getAllValues();
    }


}
