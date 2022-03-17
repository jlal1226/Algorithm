package Example;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();

        // put(), get()
        map.put("A", 100);
        map.put("B", 200);
        map.put("C", 300);
        map.put("D", 400);

        System.out.println(map);
        System.out.println(map.get("A"));
        System.out.println(map.get("B"));
        System.out.println(map.get("C"));

        // containsKey()
        if (!map.containsKey("Z")) {
            map.put("Z", 100);
        }
        System.out.println(map);

        // putIfAbsent()
        map.putIfAbsent("Z",300);
        System.out.println(map);

        Map<String, Integer> map2 = new HashMap();
        map2.put("test1", 123);
        map2.put("test2", 456);

        map.putAll(map2);
        System.out.println(map);
        System.out.println(map2);

        for (String str : map.keySet()) {
            System.out.print(str + " ");
        }
    }
}
