package com.dumiduh.constants;

public class Constants {

    /***
     * URLs
     */
    public static final String DROPDOWN_PAGE_URL = "https://the-internet.herokuapp.com/dropdown";

    /**
     * Other constants.
     */
    public static final int DEFAULT_WAIT_TIME = 60;
    public static String RUN_HEADLESS = System.getProperty("SELENIUM_HEADLESS", "false");
    public static String BROWSER = System.getProperty("BROWSER","chrome");
}
