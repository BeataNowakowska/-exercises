package testingdojo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class DataIncorrectException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataIncorrectException(String message) {
		super(message);
	}
}

class IncorrectKeyException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IncorrectKeyException(String key) {
		super("There is no " + key + " value in configuration file.");
	}
}

class ConfigurationManager {

	public static final String EXCEPTION_TWO_EQUAL_CHARACTERS = "Configuration file malformed. More then one \'=\' in line";
	public static final String EXCEPTION_NO_EQUAL_CHARACTERS = "Configuration file malformed. No \'=\' in line";

	private String configurationFilePath;
	private Map<String, String> values = new HashMap<String, String>();

	public ConfigurationManager(String configurationFilePath) {
		this.configurationFilePath = configurationFilePath;
	}

	public void readConfiguration() throws IOException, DataIncorrectException {
		List<String> readedData = Files.readAllLines(Paths.get(configurationFilePath));

		for (int i = 0; i < readedData.size(); i++) {
			String[] data = readedData.get(i).split("=");

			if (data.length > 2) {
				throw new DataIncorrectException(EXCEPTION_TWO_EQUAL_CHARACTERS);
			} else {
				if (data.length < 2) {
					throw new DataIncorrectException(EXCEPTION_NO_EQUAL_CHARACTERS);
				} else {
					values.put(data[0].trim(), data[1].trim());
				}
			}
		}
	}

	public String getValue(String key) throws IncorrectKeyException {
		if (values.containsKey(key)) {
			return values.get(key);
		} else {
			throw new IncorrectKeyException(key);
		}

	}
}

public class Example_4 {

	@Test
	public void readConfigurationCorrectLineWithLotsOfTabs()
			throws IOException, DataIncorrectException, IncorrectKeyException {
		// given
		ConfigurationManager configurationFile = new ConfigurationManager("CorrectLineWithLotsOfTabs.txt");
		// when
		configurationFile.readConfiguration();
		Assert.assertEquals("b", configurationFile.getValue("a"));
	}

	@Test(expected = DataIncorrectException.class)
	public void readConfigurationLineWithTwoEqualCharacters() throws IOException, DataIncorrectException {
		ConfigurationManager configurationFile = new ConfigurationManager("LineWithTwoTabs.txt");
		configurationFile.readConfiguration();
	}
}
