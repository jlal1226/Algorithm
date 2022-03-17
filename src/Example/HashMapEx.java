package Example;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();

        // put(), get()
        map.put("A", 1);
        map.put("B", 1);
        map.put("C", 1);
        map.put("D", 1);

        System.out.println(map.get("A"));
        System.out.println(map.get("B"));
        System.out.println(map.get("C"));

        System.out.println(map);

        // containsKey()
        if (!map.containsKey("Z")) {
            map.put("Z", 1);
        }
        //System.out.println(map);

        // putIfAbsent()
        map.putIfAbsent("Z",3);

        // getOrDefault() -> 동일한 키 찾아서 값을 덮어씀
        String[] arr = {"A", "B", "C"};
        for (String key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        System.out.println(map);


        Map<String, Integer> map2 = new HashMap<>();
        map2.put("test1", 9);
        map2.put("test2", 9);

        map.putAll(map2);
        System.out.println(map);
        System.out.println(map2);

        for (String str : map.keySet()) {
            System.out.print(str + " ");
        }


    }
}
