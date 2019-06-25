package properties;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {

    private static String pathToPropertyFile = "common.properties";


    public static String getProperty(String key) {
        return getValuePipeline(pathToPropertyFile, key);
    }

    private static String getPropertyValueFromFile(String path, String key) {
        return getPropertyFile(path).getProperty(key);
    }

    private static Properties getPropertyFile(String pathToPropertyFile) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(pathToPropertyFile));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static String getValuePipeline(String path, String key) {
        String localProperty = getPropertyValueFromFile(path, key);
        if (localProperty != null) {
            return localProperty;
        }
        return "Property Value is not defined";
    }
}
