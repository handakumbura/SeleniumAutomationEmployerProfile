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

public class JSONUtil {

    public static TestData readTestData() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"dumiduh"+File.separator+"resources"+File.separator+"testdata.json")));
            ArrayList<Object> obj = new Gson().fromJson(json, new TypeToken<Collection<TestData>>() {
            }.getType());
            return (TestData) obj.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

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

}

