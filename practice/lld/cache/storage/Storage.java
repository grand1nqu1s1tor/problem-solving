package cache.storage;

import com.sun.jdi.Value;

public interface Storage<Key, Value> {
    public void add(Key key, Value value);

    public void remove(Key key);

    public Value get(Key key);
}
