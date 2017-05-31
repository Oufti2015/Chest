package sst.chest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;

public class Chest {
    private Map<Class<?>, List<Object>> data = new HashMap<>();
    @Getter
    final private ChestConfig chestConfig;

    public Chest(ChestConfig chestConfig) {
	this.chestConfig = chestConfig;
    }

    public List<?> object(Class<?> objectClass) {
	return data.get(objectClass);
    }

    public void add(Object object) {
	List<Object> temp = data.get(object.getClass());
	if (temp == null) {
	    temp = new ArrayList<>();
	    data.put(object.getClass(), temp);
	}
	temp.add(object);
    }

    public void addAll(List<Object> list) {
	for (Object object : list) {
	    this.add(object);
	}
    }

    Set<Class<?>> typesList() {
	return chestConfig.getFilenames().keySet();
    }
}
