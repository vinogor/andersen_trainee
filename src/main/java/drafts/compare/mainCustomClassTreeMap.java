package drafts.compare;

import java.util.Map;
import java.util.TreeMap;

public class mainCustomClassTreeMap {

    // В качестве коллюча мапы - кастомный класс.
    // отсортировать через по какому-то полю кастомного класса через добавление интерфейса Comparable

   public static void main(String[] args) {

        Map<Items, String> map = new TreeMap<>();

        map.put(new Items("key_string1", 123), "value_1");
        map.put(new Items("key_string2", 13), "value_2");
        map.put(new Items("key_string3", 1235), "value_3");

        System.out.println(map);

    }

    static class Items implements Comparable<Items> {
        String s;
        int i;

        public Items(String s, int i) {
            this.s = s;
            this.i = i;
        }
        @Override
        public int compareTo(Items o) {
            return i - o.i; // по возрастанию
        }
    }

/*  // В качестве коллюча мапы - кастомный класс.
    // отсортировать через Comparator по какому-то полю кастомного класса

   public static void main(String[] args) {

        Map<Items, String> map = new TreeMap<>(new Comparator<Items>() {
            @Override
            public int compare(Items o1, Items o2) {
                return o1.i - o2.i;
            }
        });

        map.put(new Items("key_string1", 123), "value_1");
        map.put(new Items("key_string2", 13), "value_2");
        map.put(new Items("key_string3", 1235), "value_3");

        System.out.println(map);

    }

    static class Items {
        String s;
        int i;

        public Items(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }
    */

}