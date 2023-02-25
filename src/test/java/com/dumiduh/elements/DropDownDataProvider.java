package com.dumiduh.elements;

import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

/***
 * The objective of this class is to demonstrate data driven testing using a TestNG data provider.
 */

public class DropDownDataProvider {

    @DataProvider(name = "generateTestData")
    public static Object[][] generateData() {
        ArrayList<Object> data = JSONUtil.readAllTestData();

        TestData[][] dataItems = new TestData[data.size()][1];
        for (int x = 0; x < data.size(); x++) {
            dataItems[x][0] = (TestData) data.get(x);
        }

        return dataItems;
    }
}
