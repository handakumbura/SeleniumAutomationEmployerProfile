package com.dumiduh.utils;

import java.io.File;

public class FileUtil {

    public static boolean isFileAvailableInTheGivenLocation(String location) {
        File file = new File(location);
        return file.exists();
    }

    public static File[] getListOfFiles(String location) {
        File file = new File(location);
        return file.listFiles();
    }
}
