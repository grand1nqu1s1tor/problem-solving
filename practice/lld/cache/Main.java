package cache;

import cache.policies.LRUEvictionPolicy;
import cache.storage.MapBasedStorage;

public class Main {
    public static void main(String[] args) {
        // Initialize cache with a capacity of 3
        LRUEvictionPolicy<Integer> evictionPolicy = new LRUEvictionPolicy<>();
        MapBasedStorage<Integer, String> storage = new MapBasedStorage<>(3);
        Cache<Integer, String> cache = new Cache<>(evictionPolicy, storage);
        // Add elements to the cache
        cache.put(1, "A");  // Added key: 1, value: A
        cache.put(2, "B");  // Added key: 2, value: B
        cache.put(3, "C");  // Added key: 3, value: C

        // Retrieve elements
        cache.get(1);  // Retrieved A
        cache.get(4);  // Key not found: 4

        // Add another element - test for capacity
        cache.put(4, "D");  // Should fail gracefully or indicate eviction is needed.

        // Retrieve remaining elements
        cache.get(3);  // Retrieved key: 3, value: C
        cache.get(4);  // Retrieved key: 4, value: D
    }
}
