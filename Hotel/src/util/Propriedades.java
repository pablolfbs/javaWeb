package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {

	private Propriedades() {
		throw new IllegalStateException("Utility class");
	}

	public static Properties getProp() {

		Properties props = new Properties();
		try (FileInputStream file = new FileInputStream(
				"C:\\dev\\workspaces\\eclipse-workspace\\javaWeb\\Hotel\\file.properties");) {
			props.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
		
	}

}
