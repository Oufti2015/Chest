package sst.chest;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ChestTest {

    @Test
    public void saveTest() {
	Chest chest = new ChestBuilder().filename(String.class, "test.json").build();

	Assert.assertNotNull(chest);

	List<String> strings = Arrays.asList("un", "deux", "trois", "quatre");

	chest.add("cinq");
	chest.add("six");
	chest.add("sept");
	chest.add("huit");

	ChestSaver.save(chest);

	Assert.assertTrue(new File("test.json").exists());
	// chest.addAll(strings);
    }

    @Test
    public void loadTest() {
	Chest chest = new ChestBuilder().filename(String.class, "test.json").build();

	Assert.assertNotNull(chest);

	ChestLoader.load(chest);

	Assert.assertEquals(1, chest.typesList().size());

	System.out.println(chest.object(String.class));
    }
}
