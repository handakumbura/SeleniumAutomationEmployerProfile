package com.dumiduh.page;

import io.github.handakumbura.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class TablePage extends PageBase {
    private final By TABLE_XPATH = By.xpath("//table[2]");
    private WebDriver driver;
    private Table table;


    public TablePage(WebDriver driver) {
        this.driver = driver;
        table = new Table(driver, TABLE_XPATH);
    }

    /***
     * Returns the list of column headers.
     * @return The column headers.
     */
    public List<String> getColumnHeaders() {
        return table.getColumnHeaders();
    }

    /***
     * Gets the list of column values at a given row.
     * @param row the row.
     * @return List of values.
     */
    public List<String> getValuesForAGivenRow(int row) {
        return table.getValuesForAGivenRow(row);
    }

    /***
     * Gets the value for a row and column combination.
     * @param row The row.
     * @param column The column.
     * @return The value.
     */
    public String getValuesForAGivenRowAndColumn(int row, int column) {
        return table.getValuesForAGivenRowAndColumn(row, column);
    }

    /***
     * Returns all the values (excluding the column headers).
     * @return The values.
     */
    public Map<Integer, List<String>> getAllValues() {
        return table.getAllValues();
    }

}
