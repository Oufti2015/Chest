package sst.chest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import sst.textfile.InputTextFile;
import sst.textfile.InputTextFileImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChestLoader<T> {
    public void load(Chest<T> chest) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        ChestConfig chestConfig = chest.getChestConfig();

        try {
            InputTextFile input = new InputTextFileImpl(chestConfig.file());
            List<T> list = new ArrayList<>();
            list = gson.fromJson(String.join(" ", input.lines()), list.getClass());
            chest.addAll(list);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public Chest<T> load() {
        Chest<T> chest = null;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        ChestConfig chestConfig = null;
        try {
            InputTextFile input = new InputTextFileImpl(ChestConfig.configFile("."));
            chestConfig = gson.fromJson(String.join(" ", input.lines()), ChestConfig.class);
        } catch (JsonSyntaxException | IOException e) {
            e.printStackTrace();
        }

        chest = new Chest<>(chestConfig);
        load(chest);
        return chest;
    }
}
