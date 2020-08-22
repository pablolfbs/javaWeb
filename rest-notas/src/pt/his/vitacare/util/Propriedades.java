package pt.his.vitacare.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propriedades {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./src/pt/his/vitacare/util/file.properties");
		props.load(file);
		return props;
	}

}
