package com.asecu.filemanagers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
    private static Properties properties;

    public PropertiesFileReader() {
        BufferedReader reader;
        String PROPERTIES_FILE_PATH = "src\\main\\resources\\test.properties";
        try {
            reader = new BufferedReader(new FileReader(PROPERTIES_FILE_PATH));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties file was not found at " + PROPERTIES_FILE_PATH);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) new PropertiesFileReader();
        String property = properties.getProperty(key);
        if (property != null) return property;
        else
            throw new RuntimeException("The " + key + " property is not specified within properties file");

    }
}
