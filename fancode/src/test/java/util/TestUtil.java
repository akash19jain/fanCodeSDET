package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class TestUtil {
    public static Logger LOGGER = LogManager.getLogger(TestUtil.class);
    //read data from properties file
    public static String readDataFromPropertiesFile(String fileName, String variable) throws IOException {
        Properties prop = new Properties();
        try {
            prop.load(TestUtil.class.getClassLoader().getResourceAsStream(fileName));
        }catch (IOException e){
            LOGGER.error("Eror reading properties file",e);
        }

        return prop.getProperty(variable);
    }

    //reading data from properties.data file
    public static String getRoutes(String variable) throws IOException {
        String routesFile = "routes.properties";
        return readDataFromPropertiesFile(routesFile,variable);
    }
}
