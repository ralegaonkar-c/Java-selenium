package org.finsys.finance.gfl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigReader {

    private Map<String, String> xpathMap;

    private void loadConfig(String fileName) {

        try (InputStream inputStream = getClass().getResourceAsStream("/xpathconf/" + fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
             
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into key and value
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    xpathMap.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as necessary
        }
    }
    
    public ConfigReader(String fileName) {
        xpathMap = new HashMap<>();
        loadConfig(fileName);
    }    

    public String getXPath(String key) {
        return xpathMap.get(key);
    }


//public static void main(String[] args) {
//    ConfigReader configReader = new ConfigReader("xpathKV.conf");
//    String xpath = configReader.getXPath("totalEmployee"); // Replace "someKey" with the actual key you want to retrieve
//    System.out.println("XPath for the key: " + xpath);
//}

}

