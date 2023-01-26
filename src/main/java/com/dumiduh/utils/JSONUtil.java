package com.dumiduh.utils;

import com.dumiduh.models.Configurations;
import com.dumiduh.models.TestData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.dumiduh.constants.Constants.LOG_LEVEL;

public class JSONUtil {
    protected static Logger logger;

    /***
     *  Reads the test data.
     * @return TestData object,
     */
    public static TestData readTestData() {
        try {
            configureLogger();
            String json = new String(Files.readAllBytes(Paths.get("src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "dumiduh" + File.separator + "resources" + File.separator + "testdata.json")));
            ArrayList<Object> obj = new Gson().fromJson(json, new TypeToken<Collection<TestData>>() {
            }.getType());
            logger.log(Level.INFO,"The test data was successfully read from file.");
            return (TestData) obj.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * Reads the configuration.
     * @return The Configuration object.
     */
    public static Configurations readConfigurations(){
        try {
            String json = new String(Files.readAllBytes(Paths.get("src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"dumiduh"+File.separator+"resources"+File.separator+"properties.json")));
            ArrayList<Object> obj = new Gson().fromJson(json, new TypeToken<Collection<Configurations>>() {
            }.getType());

            return (Configurations) obj.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static void configureLogger() {
        logger = Logger.getLogger(JSONUtil.class.getName());
        logger.setLevel(LOG_LEVEL);

        try {
            Handler fileHandler = new FileHandler("src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "dumiduh" + File.separator + "resources" + File.separator + "logs" + File.separator + "runtime.log", 10000, 1);
            fileHandler.setFormatter(new MyFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

