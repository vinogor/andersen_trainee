package intrnshp_05_Map;

import java.util.Collection;
import java.util.Set;


public class Map<K, V> implements MapInterface<K, V> {

    //    private LinkedList<Entry<K, V>>[] table;

    private int capacity;    // максимальная вместимость массива с парами
    private int index = -1;  // указатель на последнюю заполненную ячейку с парой
    private Entry<K, V>[] arrForEntries;

    public Map(int capacity) {
        this.capacity = capacity;
        arrForEntries = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        // проверить на переполнение
        int i = isKeyUnique(key);
        if (i == -1) {
            index++;
            arrForEntries[index] = new Entry(key, value);
        } else {
            arrForEntries[i].value = value;
        }
    }

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

    @Override
    public int size() {
        return index + 1;
    }

    @Override
    public boolean containsKey(K key) {
        return isKeyUnique(key) != -1;
    }

    @Override
    public boolean containsValue(K value) {

        for (int i = 0; i < index + 1; i++) {
            if ( ((value == null) && (arrForEntries[i].value == null)) ||
                 ((value != null) && (value.equals(arrForEntries[i].value))) )
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public V getValue(K key) {
        int i = isKeyUnique(key);
        if (i == -1) {
            throw new RuntimeException(); // такого ключа нет, дописать
        }
        return arrForEntries[i].value;
    }

    @Override
    public boolean remove(K key) {
        int i = isKeyUnique(key);
        if (i == -1) {
            return false;
        }
        Entry[] buff = new Entry[capacity];
        System.arraycopy(arrForEntries, 0, buff, 0, index);
        System.arraycopy(arrForEntries, i+1, buff, i, capacity - index);
        arrForEntries = buff;
        index--;
        return true;
    }

    @Override
    public void putAll(MapInterface<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

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

    private static class Entry<K, V> {

        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}