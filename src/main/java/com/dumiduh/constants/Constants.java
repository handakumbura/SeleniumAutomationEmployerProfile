package com.dumiduh.constants;

import java.util.logging.Level;

public class Constants {

    private Constants(){
        //added for lint compliance.
    }

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


    // Log level.
    public static final Level LOG_LEVEL = Level.INFO;


}
