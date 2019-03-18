package drafts.compare;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class mainComparator {

    // например отсортировать по кол-ву символов в ключе-строке

    public static void main(String[] args) {


        // способ 1) превращаем мапу в сэт, сэт в список -> сортируем с добавлением Comparator
        //        Map<String, String> map = new HashMap();

        // способ 2) - создаём TreeMap и подаём в него Comparator
        Map<String, String> map = new TreeMap<>(new Comparator<String>() {   // сортировка может быть только по ключу
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); // по возрастанию
            }
        }
        );

        map.put("qqqKEY", "qqq");
        map.put("wwedwwKEY", "www");
        map.put("eeeKEY", "eee");
        map.put("rwedwedwedrrKEY", "rrr");
        map.put("tKEY", "ttt");
        map.put("yywed4654yKEY", "yyy");
        map.put("uuu6546546456454KEY", "uuu");
        map.put("iiiKEY", "iii");


/*   //  кусок 1 способа:

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
*/

        System.out.println(map);

    }
}
