package cache.policies;


import cache.ds.DoublyLinkedList;
import cache.ds.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    //Custom Doubly Linked List and Hashmap to keep track of keys accessed and manage the eviction.
    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy() {
        this.dll = new DoublyLinkedList();
        this.map = new HashMap();
    }

    @Override
    public void keyAccessed(Key key) {
        if(map.containsKey(key)){
            //Detach the node and add at the last
            dll.detachNode(map.get(key));
            dll.addNodeLast(map.get(key));
        }
        else{
            //Create a new node add at the last
            DoublyLinkedListNode<Key> newNode = new DoublyLinkedListNode<>(key);
            map.put(key, newNode);
            dll.addNodeLast(map.get(key));
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) return null;
        dll.detachNode(first);
        return first.getElement();
    }
}
