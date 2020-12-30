package sst.chest;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Chest<T> {
    private List<T> data = new ArrayList<>();
    @Getter
    private final ChestConfig chestConfig;

    public Chest(ChestConfig chestConfig) {
        this.chestConfig = chestConfig;
    }

    public List<T> objects() {
        return data;
    }

    public void add(T object) {
        data.add(object);
    }

    public void addAll(List<T> list) {
        data.addAll(list);
    }
}
