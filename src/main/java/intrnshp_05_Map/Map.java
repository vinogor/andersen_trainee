package intrnshp_05_Map;

/**
 * Map, generalized collection, key-value pair storage.
 * Allowed to store null as a key and/or value.
 *
 * @param <K> - key of pair
 * @param <V> - value of pair
 * @author - Andreev Aleksandr, al.andreev@andersenlab.com
 */
public class Map<K, V> implements MapInterface<K, V> {

    private int capacity;
    private int index = -1;
    private Entry<K, V>[] arrForEntries;

    /**
     * Set maximum map size.
     *
     * @param capacity -  maximum amount of items in map.
     */
    public Map(int capacity) {
        this.capacity = capacity;
        arrForEntries = new Entry[capacity];
    }

    /**
     * Put pair in the map. Pair with the same key will be overwritten.
     *
     * @param key - key of pair.
     * @param value - value of pair.
     * @throws ArrayIndexOutOfBoundsException - when try to put item in already full map.
     */
    @Override
    public void put(K key, V value) throws ArrayIndexOutOfBoundsException {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: map already full");
        }
        int i = isKeyUnique(key);
        if (i == -1) {
            index++;
            arrForEntries[index] = new Entry(key, value);
        } else {
            arrForEntries[i].value = value;
        }
    }

    /**
     * Get amount of pairs in the map.
     *
     * @return - amount of pairs in the map.
     */
    @Override
    public int size() {
        return index + 1;
    }

    /**
     * Checks the presence of the entered key in the map.
     *
     * @param key - key of pair
     * @return - true if there is such a key, false if not.
     */
    @Override
    public boolean containsKey(K key) {
        return isKeyUnique(key) != -1;
    }

    /**
     * Checks the presence of the entered value in the map.
     *
     * @param value - value of pair
     * @return - true if there is such a value, false if not.
     */
    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < index + 1; i++) {
            if ( ((value == null) && (arrForEntries[i].value == null)) ||
                 ((value != null) && (value.equals(arrForEntries[i].value))) )
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns value of pair with entered key.
     *
     * @param key - entered key of pair.
     * @return - value of pair with entered key.
     * @throws ArrayIndexOutOfBoundsException - when try to get value in empty map.
     * @throws IllegalArgumentException - when entered key is not exist.
     */
    @Override
    public V getValue(K key) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: map is empty");
        }
        int i = isKeyUnique(key);
        if (i == -1) {
            throw new IllegalArgumentException("This key does not exist");
        }
        return arrForEntries[i].value;
    }

    /**
     * Remove a pair from map by key.
     *
     * @param key - entered key of the pair to be deleted.
     * @throws ArrayIndexOutOfBoundsException - when try to remove pair in empty map.
     * @throws IllegalArgumentException - when entered key is not exist.
     */
    @Override
    public void remove(K key) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: map is empty");
        }
        int i = isKeyUnique(key);
        if (i == -1) {
            throw new IllegalArgumentException("This key does not exist");
        }
        if (index != 0) {
            Entry[] buff = new Entry[capacity];
            System.arraycopy(arrForEntries, 0, buff, 0, index);
            System.arraycopy(arrForEntries, i+1, buff, i, capacity - index);
            arrForEntries = buff;
            index--;
        } else {
            index = -1;
        }
    }

    /**
     * Make map clear.
     *
     * @throws ArrayIndexOutOfBoundsException - when try to clear already empty map.
     */
    @Override
    public void clear() throws ArrayIndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ERROR: map already empty");
        }
        index = -1;
    }

    /**
     * Checks for the presence in the map of a pair with the key entered.
     *
     * @param key - key to find a pair.
     * @return - if key already exist: return index of pair in array.
     *         - if key does not exist: return -1.
     */
    private int isKeyUnique(K key) {
        if (index == -1) {
            return -1;
        }
        for (int i = 0; i < index + 1; i++) {
            if  ( ((key == null) && (arrForEntries[i].key == null)) ||
                    ((key != null) && (key.equals(arrForEntries[i].key))) )
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Display the contents of the entire map array on the screen (including empty cells).
     */
    @Override
    public void printAll() {
        System.out.println("__key:__ | __value:__ | size = " + size());
        for (int i = 0; i < capacity; i++) {
            if (arrForEntries[i] == null) {
                System.out.println("--- | ---");
            } else {
                System.out.println(arrForEntries[i].key + " | " + arrForEntries[i].value);
            }
        }
        System.out.println();
    }

    private boolean isEmpty() {
        return index == -1;
    }

    private boolean isFull() {
        return index + 1 == capacity;
    }

    /**
     * Structure of pair of array for map
     *
     * @param <K> - key of pair
     * @param <V> - value of pair
     */
    private static class Entry<K, V> {
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}