package sst.chest;

import sst.chest.ChestConfig.OutputFormat;

public class ChestBuilder {
    private ChestConfig chestConfig = new ChestConfig();

    public ChestBuilder outputFormat(OutputFormat outputFormat) {
	this.chestConfig.setOutputFormat(outputFormat);
	return this;
    }

    public ChestBuilder versioning(Boolean versioning) {
	this.chestConfig.setVersioning(versioning);
	return this;
    }

    public ChestBuilder outputFolder(String outputFolder) {
	this.chestConfig.setOutputFolder(outputFolder);
	return this;
    }

    public ChestBuilder inputFolder(String inputFolder) {
	this.chestConfig.setInputFolder(inputFolder);
	return this;
    }

    public ChestBuilder filename(Class<?> objectClass, String filename) {
	this.chestConfig.addFilename(objectClass, filename);
	return this;
    }

    public Chest build() {
	return new Chest(this.chestConfig);
    }
}
