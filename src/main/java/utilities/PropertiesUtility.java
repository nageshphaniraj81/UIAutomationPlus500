package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertiesUtility {

	static Properties prop = new Properties();

	public static String getPropertyValueByKey(String key) {

		// 1. load data from properties file
		String propFilePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2. read data
		String value = prop.get(key).toString();

		if (StringUtils.isEmpty(value)) {
			try {
				throw new Exception("Value is not specified for key: " + key + " in properties file.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("Property value is " + value);
		return value;
	}

}
