package com.dumiduh.elements;

import com.dumiduh.function.TablePageFunctions;
import com.dumiduh.utils.TestBase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.dumiduh.constants.Constants.TABLE;

public class TablePageTest extends TestBase {

    @BeforeClass
    public static void setup() {
        instantiateDriver();
        driver.get(TABLE);
    }

    @Test
    public static void tableTest() {
        TablePageFunctions tablePageFunctions = new TablePageFunctions(driver);

        tablePageFunctions.getColumnHeaders();
        tablePageFunctions.getValuesForAGivenRow(1);
        tablePageFunctions.getValuesForAGivenRowAndColumn(1,2);
        tablePageFunctions.getAllValues();
    }


    @AfterClass
    public static void cleanUp() {
        driver.quit();
    }
}
