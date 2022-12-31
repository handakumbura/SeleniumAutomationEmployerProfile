package com.dumiduh.page;

import io.github.handakumbura.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class TablePage extends PageBase {
    private final By TABLE_XPATH = By.xpath("//table[2]");
    private ChromeDriver driver;
    private Table table;


    public TablePage(ChromeDriver driver) {
        this.driver = driver;
        table = new Table(driver, TABLE_XPATH);
    }

    public List<String> getColumnHeaders() {
        return table.getColumnHeaders();
    }

    public List<String> getValuesForAGivenRow(int row) {
        return table.getValuesForAGivenRow(row);
    }

    public String getValuesForAGivenRowAndColumn(int row, int column) {
        return table.getValuesForAGivenRowAndColumn(row, column);
    }

    public Map<Integer, List<String>> getAllValues() {
        return table.getAllValues();
    }

}
