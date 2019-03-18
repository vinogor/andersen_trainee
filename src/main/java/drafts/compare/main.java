package drafts.compare;

import java.util.*;

public class main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap();

        map.put("qqqKEY", "qqq");
        map.put("wwedwwKEY", "www");
        map.put("eeeKEY", "eee");
        map.put("rwedwedwedrrKEY", "rrr");
        map.put("tKEY", "ttt");
        map.put("yywed4654yKEY", "yyy");
        map.put("uuu6546546456454KEY", "uuu");
        map.put("iiiKEY", "iii");

        // отсортировать по кол-ву символов в ключе-строке
        // способ 1) превращаем в список -> сортируем с добавлением Comparator

        Set<Map.Entry<String, String>> entries = map.entrySet();
        List list = new ArrayList(entries);

        System.out.println(list);

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().length() - o2.getKey().length(); // по возрастанию
            }
        });

        System.out.println(list);




    }

}
