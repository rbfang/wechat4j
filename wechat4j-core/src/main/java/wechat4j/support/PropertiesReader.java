package wechat4j.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.Properties;

/**
 * PropertiesReader
 *
 * @author renbin.fang.
 * @date 2014/9/15.
 */
public class PropertiesReader {
    private String propertiesPath;
    private Properties properties;

    private final Log logger = LogFactory.getLog(getClass());

    /**
     * Constructor
     */
    public PropertiesReader() {
    }

    /**
     * Constructor
     *
     * @param propertiesPath
     */
    public PropertiesReader(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }

    /**
     * Loading properties from file
     */
    public void load() {
        File propertiesFile = new File(getClass().getResource(propertiesPath).getFile());
        if (!propertiesFile.exists()) {
            logger.error("properties file does not exist. path=" + propertiesPath);

            return;
        }

        this.properties = new Properties();
        try {
            //TODO needs to improve
            FileInputStream fileInputStream = new FileInputStream(propertiesFile);
            this.properties.load(fileInputStream);
            logger.info("Success to load properties file. path=" + propertiesPath);

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Failed to load properties file. path=" + propertiesPath);
        }

        return;
    }

    /**
     * Getting string
     *
     * @param key
     * @return
     */
    public String getString(String key) {
        String value;
        if (properties != null) {
            value = properties.getProperty(key);
        } else {
            value = null;
        }


        return value;
    }

    public void setPropertiesPath(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }
}
