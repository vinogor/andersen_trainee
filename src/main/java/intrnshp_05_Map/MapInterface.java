package intrnshp_05_Map;

public interface MapInterface<K, V> {

    /**
     * Put pair in the map. Pair with the same key will be overwritten.
     *
     * @param key - key of pair.
     * @param value - value of pair.
     * @throws ArrayIndexOutOfBoundsException - when try to put item in already full map.
     */
    void put(K key, V value);

    /**
     * Get amount of pairs in the map.
     *
     * @return - amount of pairs in the map.
     */
    int size();

    /**
     * Checks the presence of the entered key in the map.
     *
     * @param key - key of pair
     * @return - true if there is such a key, false if not.
     */
    boolean containsKey(K key) ;

    /**
     * Checks the presence of the entered value in the map.
     *
     * @param value - value of pair
     * @return - true if there is such a value, false if not.
     */
    boolean containsValue(V value);

    /**
     * Returns value of pair with entered key.
     *
     * @param key - entered key of pair.
     * @return - value of pair with entered key.
     * @throws ArrayIndexOutOfBoundsException - when try to get value in empty map.
     * @throws IllegalArgumentException - when entered key is not exist.
     */
    V getValue(K key);

    /**
     * Remove a pair from map by key.
     *
     * @param key - entered key of the pair to be deleted.
     * @throws ArrayIndexOutOfBoundsException - when try to remove pair in empty map.
     * @throws IllegalArgumentException - when entered key is not exist.
     */
    void remove(K key);

    /**
     * Make map clear.
     *
     * @throws ArrayIndexOutOfBoundsException - when try to clear already empty map.
     */
    void clear();

    /**
     * Display the contents of the entire map array on the screen (including empty cells).
     */
    void printAll();
}
