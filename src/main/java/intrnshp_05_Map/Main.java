package intrnshp_05_Map;

public class Main {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("123", "adadqw");
//        map.putAll();

//        Collection<String> c = new Collection<String>() {
//        }
//
//
//        Set<Integer> set1 = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return 0;  // типо в любом случае они будут РАВНЫ, а значит перезапись при добавлении
//            }
//        });
//
//        Set<Integer> set = new TreeSet<>();
//
//        set1.add(1);
//        set1.add(2);
//        set1.add(1);
//
//        System.out.println(set1);


        MapInterface<String, String> map = new Map<>(5);

        map.put("key_1", "value_1");
        map.put(null, "qweqwe");
        map.printAll();

        map.put("key_1", null);
        map.printAll();

        map.put(null, null);
        map.put("key_2", "value_1");
        map.put("key_3", "value_3");
        map.printAll();
//        System.out.println(map.containsKey("key_222"));
//        System.out.println(map.containsKey(null));
//
//        System.out.println(map.containsValue(null));
//        System.out.println(map.containsValue("afasdf"));
//        System.out.println(map.containsValue("value_1"));

        map.remove(null);
        map.printAll();


    }
}
