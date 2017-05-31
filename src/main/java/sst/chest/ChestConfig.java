package sst.chest;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ChestConfig {
    public enum OutputFormat {
	JSON
    };

    private OutputFormat outputFormat = OutputFormat.JSON;
    private Boolean versioning = false;
    private String outputFolder = ".";
    private String inputFolder = ".";
    private Map<Class<?>, String> filenames = new HashMap<>();

    public ChestConfig addFilename(Class<?> objectClass, String filename) {
	filenames.put(objectClass, filename);
	return this;
    }

    public String filename(Class<?> objectClass) {
	return filenames.get(objectClass);
    }
}
