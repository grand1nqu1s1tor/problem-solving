package cache.policies;

//Declare an interface which is implemented by the Eviction Policy class
public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    Key evictKey();

}
