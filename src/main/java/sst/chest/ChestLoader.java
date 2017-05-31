package sst.chest;

import java.io.File;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sst.textfile.InputTextFile;
import sst.textfile.InputTextFileImpl;

public class ChestLoader {
    public static void load(Chest chest) {
	Gson gson = new GsonBuilder()
		.setPrettyPrinting()
		.serializeNulls()
		.create();

	ChestConfig chestConfig = chest.getChestConfig();

	for (Class<?> objectType : chest.typesList()) {
	    try {
		InputTextFile input = new InputTextFileImpl(new File(chestConfig.filename(objectType)));
		@SuppressWarnings("unchecked")
		List<Object> list = gson.fromJson(String.join(" ", input.lines()), List.class);
		chest.addAll(list);
	    } catch (Exception e1) {
		e1.printStackTrace();
	    }
	}
    }
}
