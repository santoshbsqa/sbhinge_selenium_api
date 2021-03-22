package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		System.out.println(
				"configpath-" + TestBase.projectPath + "\\src\\test\\resources\\config\\configuration.properties");
		InputStream input = new FileInputStream(
				TestBase.projectPath + "\\src\\test\\resources\\config\\configuration.properties");
		prop.load(input);
		return prop;
	}
}
