package sst.chest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sst.common.file.output.OutputFile;

import java.io.IOException;

public class ChestSaver<T> {

    public void save(Chest<T> chest) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        ChestConfig chestConfig = chest.getChestConfig();
        try (OutputFile output = new OutputFile(ChestConfig.configFile("."))) {
            output.println(gson.toJson(chestConfig));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputFile output = new OutputFile(chestConfig.file())) {
            output.println(gson.toJson(chest.objects()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
