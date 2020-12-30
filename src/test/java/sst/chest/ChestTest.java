package sst.chest;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ChestTest {

    @Test
    public void saveTest() {
        Chest<String> chest = new ChestBuilder<String>().filename("test.json").build();

        Assert.assertNotNull(chest);

        List<String> strings = Arrays.asList("un", "deux", "trois", "quatre");

        chest.addAll(strings);
        chest.add("cinq");
        chest.add("six");
        chest.add("sept");
        chest.add("huit");

        Assert.assertEquals(8, chest.objects().size());

        new ChestSaver<String>().save(chest);

        Assert.assertTrue(new File("test.json").exists());
        // chest.addAll(strings);
    }

    @Test
    public void loadTest() {
        Chest<String> chest = new ChestBuilder().filename("test.json").build();

        Assert.assertNotNull(chest);

        new ChestLoader<String>().load(chest);

        Assert.assertEquals(8, chest.objects().size());

        System.out.println(chest.objects());
    }

    @Test
    public void loadTestWithConfig() {
        Chest<String> chest = new ChestLoader<String>().load();

        Assert.assertEquals(8, chest.objects().size());

        System.out.println(chest.objects());
    }
}
