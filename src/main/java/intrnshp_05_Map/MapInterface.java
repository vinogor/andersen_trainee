package intrnshp_05_Map;

import java.util.Collection;
import java.util.Set;

public interface MapInterface<K, V> {

    // кол-во пар в мапе
    int size();

    // содержит ли такой ключ
    boolean containsKey(K key) ;

    // содержит ли такое значение
    boolean containsValue(K value);

    // получить значение по ключу
    V getValue(K key);

    // положить пару ключ-значение, если такой ключ уже есть - запись поверх
    void put(K key, V value);

    // удалить пару по ключу, true если ключ найден
    boolean remove(K key);

    // положить мапу m в текущую мапу
    void putAll(MapInterface<? extends K, ? extends V> m);

    // всё почистить
    void clear();

    // возвращает набор всех ключей мапы
    Set<K> keySet();

    // возваращает коллекцию всех значений мапы
    Collection<V> values();

    // вывести на экран всю мапу
    void printAll();
}
