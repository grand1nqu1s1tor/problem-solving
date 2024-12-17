package cache.storage;

import java.util.HashMap;
import java.util.Map;

public class MapBasedStorage<Key, Value> implements Storage<Key, Value> {
    Map<Key, Value> storage;
    private final Integer capacity;

    public MapBasedStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) {
        if (isStorageFull()) throw new RuntimeException();
        storage.put(key, value);
    }

    @Override
    public void remove(Key key) {
        if (!storage.containsKey(key)) throw new RuntimeException();
        storage.remove(key);
    }

    @Override
    public Value get(Key key) {
        if (!storage.containsKey(key)) ;
        return storage.get(key);
    }

    private boolean isStorageFull() {
        return storage.size() == capacity;
    }
}
