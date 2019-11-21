package za.co.ilab.tshimx.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Tshimologo
 */
public class ObjectRepository {
    
     private Properties object_repo;

    public Properties loadProperties() throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("objects.properties");
        object_repo = new Properties();
        object_repo.load(inputStream);
        inputStream.close();
        return object_repo;
    }

}
