package sst.chest;

import sst.chest.ChestConfig.OutputFormat;

public class ChestBuilder<T> {
    private ChestConfig chestConfig = new ChestConfig();

    public ChestBuilder<T> outputFormat(OutputFormat outputFormat) {
        this.chestConfig.setOutputFormat(outputFormat);
        return this;
    }

    public ChestBuilder<T> versioning(Boolean versioning) {
        this.chestConfig.setVersioning(versioning);
        return this;
    }

    public ChestBuilder<T> outputFolder(String outputFolder) {
        this.chestConfig.setOutputFolder(outputFolder);
        return this;
    }

    public ChestBuilder<T> inputFolder(String inputFolder) {
        this.chestConfig.setInputFolder(inputFolder);
        return this;
    }

    public ChestBuilder<T> filename(String filename) {
        this.chestConfig.setFilename(filename);
        return this;
    }

    public Chest<T> build() {
        return new Chest<>(this.chestConfig);
    }
}
