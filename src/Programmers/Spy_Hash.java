package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spy_Hash {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"},
                {"crowmask", "face"}, {"smoky_makeup", "face"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        System.out.print(map);
        List<Integer> list = new ArrayList<>(map.values());
        for (Integer i : list) {
            answer *= i + 1;
        }

        return answer - 1;
    }
}
