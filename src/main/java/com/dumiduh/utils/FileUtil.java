package com.dumiduh.utils;

import java.io.File;

public class FileUtil {

    private FileUtil() {
        throw new IllegalStateException("Utility class");
    }

    /***
     * Checks to see if a file is available in a given location.
     * @param location
     * @return state of the function.
     */
    public static boolean isFileAvailableInTheGivenLocation(String location) {
        File file = new File(location);
        return file.exists();
    }

    /***
     * Returns information on the files available in a given location.
     * @param location
     * @return a list of Files.
     */
    public static File[] getListOfFiles(String location) {
        File file = new File(location);
        return file.listFiles();
    }
}
