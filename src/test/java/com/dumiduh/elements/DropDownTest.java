package com.dumiduh.elements;

import com.dumiduh.models.TestData;
import com.dumiduh.utils.JSONUtil;
import org.testng.annotations.Factory;

public class DropDownTest {
    static TestData data = JSONUtil.readAGivenTestDataItem("dropdownendtoend");

    @Factory
    public static Object[] DropDownTest() {

        return new Object[]{
                new DropDownPageElementsTest(),
                new DropDownUsageTest()};
    }
}
