package com.dumiduh.constants;

public class Constants {

    /***
     * URLs
     */
    public static final String URL_TEMP = "https://www.amazon.com/";


    /**
     * Other constants.
     */
    public static final int DEFAULT_WAIT_TIME_IN_SECONDS = 60;

    public static final int DEFAULT_SLEEP_TIME_IN_MILLISECONDS = 5000;
    public static final int THE_LENGTH_AT_WHICH_TO_TRUNCATE_THE_PRODUCT_NAME = 50;

    public static final String PRODUCT_NAME_POST_FIX = "…";
    public static String RUN_HEADLESS = System.getProperty("SELENIUM_HEADLESS", "false");

    public static String MAXIMIZE_THE_WINDOW = System.getProperty("MAXIMIZE_THE_WINDOW", "true");
    public static String BROWSER = System.getProperty("BROWSER","chrome");

    public static String TRUE = "true";
    public static String FALSE = "false";


}
