package cache;

import cache.policies.EvictionPolicy;
import cache.storage.Storage;
import com.sun.jdi.Value;

//Cache should have a storage and an eviction policy to evict keys when storage is full.
//Cache functionally has two methods that is putting into and getting from the cache.
public class Cache<Key, Value> {

    EvictionPolicy<Key> evictionPolicy;
    Storage<Key, Value> storage;

    public Cache(EvictionPolicy evictionPolicy, Storage storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    //Put the value in cache and update the storage
    public void put(Key key, Value value) {
        storage.add(key, value);
        evictionPolicy.keyAccessed(key);
        //TODO code for if cache is full
    }

    public Value get(Key key) {
        Value value = storage.get(key);
        evictionPolicy.keyAccessed(key);
        return value;
        //TODO code for if key not found
    }


}
