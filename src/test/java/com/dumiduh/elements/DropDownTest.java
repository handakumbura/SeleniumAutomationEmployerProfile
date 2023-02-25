package com.dumiduh.elements;

import org.testng.annotations.Factory;

public class DropDownTest {
    static String action = "action 1";
    @Factory
    public static Object[] DropDownTest() {

        return new Object[]{
                new DropDownPageElementsTest(),
                new DropDownUsageTest()};
    }
}
