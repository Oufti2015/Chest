package sst.chest;

import java.io.File;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sst.common.file.output.OutputFile;

public class ChestSaver {

    public static void save(Chest chest) {
	Gson gson = new GsonBuilder()
		.setPrettyPrinting()
		.serializeNulls()
		.create();

	ChestConfig chestConfig = chest.getChestConfig();

	for (Class<?> objectType : chest.typesList()) {
	    try (OutputFile output = new OutputFile(new File(chestConfig.filename(objectType)))) {
		output.println(gson.toJson(chest.object(objectType)));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
