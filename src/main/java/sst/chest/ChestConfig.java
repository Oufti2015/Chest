package sst.chest;

import lombok.Data;

import java.io.File;

@Data
public class ChestConfig {
    public enum OutputFormat {
        JSON
    }

    private OutputFormat outputFormat = OutputFormat.JSON;
    private Boolean versioning = false;
    private String outputFolder = ".";
    private String inputFolder = ".";
    private String filename = "data.json";

    public File file() {
        return new File(((outputFolder == null) ? "" : outputFolder + File.separator) + filename);
    }

    public static String configFileName() {
        return ChestConfig.class.getSimpleName() + ".json";
    }

    public static File configFile(String folder) {
        return new File(folder + File.separator + configFileName());
    }
}
