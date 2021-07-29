package com.yls.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author yunglee on 2021/07/20
 * @package com.yls.demo
 */
public class PropertyConfig {
    private static final Logger log = LogManager.getLogger(PropertyConfig.class);
    private static final String property_file = "application.properties";
    private static Properties properties;

    public static void load() {
        properties = new Properties();
        try(InputStream inputStream = PropertyConfig.class.getClassLoader()
                .getResourceAsStream(property_file)) {
            properties.load(inputStream);
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public static final String getAuth() {
        return get("cwb.auth");
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}
