package com.dumiduh.other;


import com.dumiduh.models.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/***
 * The objective of this class is to demonstrate data driven testing using a TestNG data provider.
 */

public class DataProviderTest {

    @DataProvider(name = "generateTestData")
    public static Object[][] generateData() {
        TestData t = new TestData();
        TestData t2 = new TestData();
        t.setStringValue("test 1");
        t.setIntValue(1);
        t2.setStringValue("test 2");
        t2.setIntValue(2);

        return new TestData[][] {{t},{t2}};
    }

    @Test(dataProvider = "generateTestData")
    public static void testDataProvider(TestData s) {
        System.out.println(s);
    }
}
