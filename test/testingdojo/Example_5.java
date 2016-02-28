package testingdojo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

class DataMalformedException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataMalformedException(String message) {
		super(message);
	}
}

class NoSuchValueException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoSuchValueException(String key) {
		super("There is no " + key + " value in configuration file.");
	}
}

class ConfigurationFile {

	public static final String EXCEPTION_TWO_EQUAL_CHARACTERS = "Configuration file malformed. More then one \'=\' in line";
	public static final String EXCEPTION_NO_EQUAL_CHARACTERS = "Configuration file malformed. No \'=\' in line";

	private List<String> testData;
	private String configurationFilePath;
	private HashMap<String, String> values = new HashMap<String, String>();

	// for test only
	public ConfigurationFile(List<String> testData) {
		this.testData = testData;
	}

	public ConfigurationFile(String configurationFilePath) {
		this.configurationFilePath = configurationFilePath;
	}

	public void ReadConfiguration() throws DataMalformedException, IOException {
		List<String> readedData;
		if (testData != null) {
			readedData = testData;
		} else {
			readedData = Files.readAllLines(Paths.get(configurationFilePath));
		}

		for (int i = 0; i < readedData.size(); i++) {
			String[] data = readedData.get(i).split("=");

			if (data.length > 2) {
				throw new DataMalformedException(EXCEPTION_TWO_EQUAL_CHARACTERS);
			} else {
				if (data.length < 2) {
					throw new DataMalformedException(EXCEPTION_NO_EQUAL_CHARACTERS);
				} else {
					values.put(data[0].trim(), data[1].trim());
				}
			}
		}
	}

	public String getValue(String key) throws NoSuchValueException {
		if (values.containsKey(key)) {
			return values.get(key);
		} else {
			throw new NoSuchValueException(key);
		}

	}
}

public class Example_5 {

	@Test
	public void ReadConfigurationCorrectLineWithLotsOfTabs()
			throws NoSuchValueException, DataMalformedException, IOException {
		// given
		ConfigurationFile configurationFile = new ConfigurationFile(
				Arrays.asList(new String[] { " a \t = \t b   \t\t" }));
		// when
		configurationFile.ReadConfiguration();
		// then
		Assert.assertEquals("b", configurationFile.getValue("a"));
	}

	@Test(expected = DataMalformedException.class)
	public void ReadConfigurationLineWithTwoEqualCharacters() throws DataMalformedException, IOException {
		ConfigurationFile configurationFile = new ConfigurationFile(Arrays.asList(new String[] { " a = b = c " }));
		configurationFile.ReadConfiguration();
	}
}
