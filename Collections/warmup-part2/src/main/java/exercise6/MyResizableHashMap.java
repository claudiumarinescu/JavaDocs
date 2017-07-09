package exercise6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Create a resizable generic HashMap. When the number of entries exceeds (load capacity * bucket array size)
 * the HashMap needs to be resized.
 *
 * Resizing (rehashing) consists in increasing the size of the bucket array with the value of
 * INCREASE_SIZE_FACTOR. After this step, all the entries that were stored in the HashMap
 * must be inserted in the new bucket array according to the insertion algorithm in a HashMap:
 * the entry must be placed in a bucket after applying the hash function (hashcode modulo (bucket array size))
 * on the key's hashcode value. The result of the hash function will return the index from the
 * bucket array where the entry will be stored. (see HashMap documentation)
 *
 * Created by Radu.Hoaghe on 7/6/2017.
 */
public class MyResizableHashMap<K, V> {

    /**
     * The array of buckets.
     */
    private Node<K, V>[] buckets;

    /**
     * Default initial capacity for the bucket array.
     */
    private final int DEFAULT_BUCKET_ARRAY_SIZE = 16;

    /**
     * The maximum accepted load property of the data structure.
     */
    private static final double LOAD_FACTOR = 0.75d;

    /**
     * The factor for increasing the size of the data structure.
     */
    private static final int INCREASE_SIZE_FACTOR = 2;

    /**
     * The number of entries stored in the Map.
     */
    private int size;

    /**
     * The capacity of the Map
     */
    private int capacity;

    public MyResizableHashMap() {
        // Initialize buckets list
        capacity = DEFAULT_BUCKET_ARRAY_SIZE;
        buckets = new Node[capacity];
        size = 0;
    }

    private void resize() {
        // function that does the rehashing of the HashMap
        Set<MyEntry> temp = this.entrySet();
        capacity *= INCREASE_SIZE_FACTOR;
        buckets = new Node[capacity];
        size = 0;

        for (MyEntry myEntry : temp) {
            put((K) myEntry.getKey(), (V) myEntry.getValue());
        }
    }

    public V get(K key) {
        V value = null;
        if (key == null) {
            for (Node<K, V> node = buckets[0]; node != null; node = node.getNextElement()) {
                if (node.getEntry().getKey() == key) {
                    value = node.getEntry().getValue();
                }
            }
        } else {
            for (Node<K, V> node = buckets[hash(key)]; node != null; node = node.getNextElement()) {
                if (node.getEntry().getKey().equals(key)) {
                    value = node.getEntry().getValue();
                }
            }
        }
        return value;
    }

    public void put(K key, V value) {
        if (size > capacity * LOAD_FACTOR) {
            resize();
        }

        int bucket = hash(key);
        if (buckets[bucket] == null) {
            MyEntry<K, V> entry = new MyEntry<K, V>(key, value);
            Node<K, V> node = new Node<K, V>(entry, bucket, null);
            buckets[bucket] = node;
            size++;
            return;
        }

        // search for the key in buckets
        Node<K, V> node = buckets[bucket];
        Node<K, V> previous = null;

        while (node != null) {
            if (key == null) {
                if (node.getEntry().getKey() == key) {
                    node.getEntry().setValue(value);
                    return;
                }
            } else {
                if (node.getEntry().getKey().equals(key)) {
                    node.getEntry().setValue(value);
                    return;
                }
            }
            previous = node;
            node = node.getNextElement();
        }

        // key was not found; create a new entry
        MyEntry<K, V> entry = new MyEntry<K, V>(key, value);
        Node<K, V> newNode = new Node<K, V>(entry, bucket, null);
        previous.nextElement = newNode;
        size++;

        return;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<K>();
        for (int i = 0; i < capacity; i++) {
            for (Node<K, V> node = buckets[i]; node != null; node = node.nextElement) {
                keys.add(node.getEntry().getKey());
            }
        }
        return keys;
    }

    public Collection<V> values() {
        Collection<V> values = new ArrayList<V>();
        for (int i = 0; i < capacity; i++) {
            for (Node<K, V> node = buckets[i]; node != null; node = node.nextElement) {
                values.add(node.getEntry().getValue());
            }
        }
        return values;
    }

    public V remove(K key) {
        // Returns the value associated with the key removed from the map or null if the key wasn't found
        V value = null;
        Node<K, V> last = null;
        if (key == null) {
            for (Node<K, V> node = buckets[0]; node != null; node = node.getNextElement()) {
                if (node.getEntry().getKey() == key) {
                    value = node.getEntry().getValue();
                    if (last == null) {
                        buckets[0] = node.nextElement;
                    } else {
                        last.nextElement = node.nextElement;
                    }
                    size--;
                    break;
                }
                last = node;
            }
        } else {
            for (Node<K, V> node = buckets[hash(key)]; node != null; node = node.getNextElement()) {
                if (node.getEntry().getKey().equals(key)) {
                    value = node.getEntry().getValue();
                    if (last == null) {
                        buckets[hash(key)] = node.nextElement;
                    } else {
                        last.nextElement = node.nextElement;
                    }
                    size--;
                    break;
                }
                last = node;
            }
        }
        return value;
    }

    public boolean containsKey(K key) {
        return keySet().contains(key);
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            for (Node<K, V> node = buckets[i]; node != null; node = node.nextElement) {
                if (node.getEntry().getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        // Return the number of the Entry objects stored in all the buckets
        return size;
    }

    public void clear() {
        // Remove all the Entry objects from the bucket list
        buckets = new Node[capacity];
        size = 0;
    }

    public Set<MyEntry> entrySet() {
        // Return a Set containing all the Entry objects
        Set<MyEntry> entries = new HashSet<MyEntry>();
        for (int i = 0; i < capacity; i++) {
            for (Node<K, V> node = buckets[i]; node != null; node = node.nextElement) {
                entries.add(node.getEntry());
            }
        }
        return entries;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int hash(K key) {
        if (key == null)    return 0;
        return Math.abs(key.hashCode() % capacity);
    }

    public static class MyEntry<K, V> {
        private K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    static class Node<K, V> {
        private final MyEntry<K, V> entry;
        private final int hash;
        private Node<K, V> nextElement;

        public Node(MyEntry<K, V> entry, int hash, Node<K, V> nextElement) {
            this.entry = entry;
            this.hash = hash;
            this.nextElement = nextElement;
        }

        public MyEntry<K, V> getEntry() {
            return entry;
        }

        public int getHash() {
            return hash;
        }

        public Node<K, V> getNextElement() {
            return nextElement;
        }
    }
}
