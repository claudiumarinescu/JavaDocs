package exercise4;

import java.util.*;

/**
 * Exercise 3. Implement a HashMap from scratch. In order to pass all the tests
 * you need to implement all the methods defined below. The key-value pair will
 * be encapsulated in the MyHashMap.MyEntry object defined below.
 *
 * The buckets list in which each MyEntry object will be stored is stored in "buckets" object.
 * The hash function that you will use in order to store a pair in a specific bucket will be
 * the one presented earlier: (hashcode value) modulo (bucket array size)
 */
public class MyHashMap {

    private ArrayList<LinkedList<MyEntry>> buckets;

    private final int BUCKET_ARRAY_SIZE = 16;

    public MyHashMap() {
        // Initialize buckets list
        buckets = new ArrayList<LinkedList<MyEntry>>();
        for (int i = 0; i < BUCKET_ARRAY_SIZE; i++) {
            buckets.add(new LinkedList<MyEntry>());
        }
    }

    public String get(String key) {
        if (key == null) {
            for (MyEntry entry : buckets.get(0)) {
                if (entry.getKey() == key) {
                    return entry.getValue();
                }
            }
        } else {
            for (MyEntry myEntry : buckets.get(hash(key))) {
                if (myEntry.getKey().equals(key)) {
                    return myEntry.getValue();
                }
            }
        }
        return null;
    }

    public void put(String key, String value) {
        // first see if key is already in the map
        MyEntry entry = null;
        int position;
        if (key == null) {
            position = 0;
            for (MyEntry myEntry : buckets.get(position)) {
                if (myEntry.getKey() == key) {
                    entry = myEntry;
                    break;
                }
            }
        } else {
            position = hash(key);
            for (MyEntry myEntry : buckets.get(position)) {
                if (myEntry.getKey().equals(key)) {
                    entry = myEntry;
                    break;
                }
            }
        }

        // key not found in map
        if (entry == null) {
            entry = new MyEntry(key, value);
            buckets.get(position).add(entry);
        }

        // key found in map; set the new value
        entry.setValue(value);
    }

    public Set<String> keySet() {
        Set<String> keys = new HashSet<String>();
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                keys.add(myEntry.getKey());
            }
        }
        return keys;
    }

    public Collection<String> values() {
        Collection<String> col = new ArrayList<String>();
        for (LinkedList<MyEntry> bucket : buckets) {
            for (MyEntry myEntry : bucket) {
                col.add(myEntry.getValue());
            }
        }

        return col;
    }

    public String remove(String key) {
        // Returns the value associated with the key removed from the map or null if the key wasn't found
        int position = (key == null) ? 0 : hash(key);
        MyEntry entry;
        String result = null;

        Iterator<MyEntry> it = buckets.get(position).iterator();
        while (it.hasNext()) {
            entry = it.next();
            if ((key == null) && (entry.getKey() == null)) {
                result = entry.getValue();
                it.remove();
                break;
            }
            if (entry.getKey().equals(key)) {
                result = entry.getValue();
                it.remove();
                break;
            }
        }

        return result;
    }

    public boolean containsKey(String key) {
        String value = get(key);
        if (value == null)  return false;
        return true;
    }

    public boolean containsValue(String value) {
        return values().contains(value);
    }

    public int size() {
        // Return the number of the Entry objects stored in all the buckets
        int size = 0;
        for (LinkedList<MyEntry> bucket : buckets) {
            size += bucket.size();
        }

        return size;
    }

    public void clear() {
        // Remove all the Entry objects from the bucket list
        for (LinkedList<MyEntry> bucket : buckets) {
            bucket.clear();
        }
    }

    public Set<MyEntry> entrySet() {
        // Return a Set containing all the Entry objects
        Set<MyEntry> entries = new HashSet<MyEntry>();
        for (LinkedList<MyEntry> bucket : buckets) {
            entries.addAll(bucket);
        }
        return entries;
    }

    public boolean isEmpty() {
        for (LinkedList<MyEntry> bucket : buckets) {
            if (bucket.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % BUCKET_ARRAY_SIZE);
    }

    public static class MyEntry {
        private String key;
        private String value;

        public MyEntry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
