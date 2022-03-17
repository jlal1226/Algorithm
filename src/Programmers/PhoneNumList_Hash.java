package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumList_Hash {
    public static void main(String[] args) {
        String[] input= { "119", "97674223", "1195524421" , "123","456","789"};
        boolean result = solution(input);
        System.out.print(result);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;

        // HashMap에서 Key를 탐색하는 방법 활용
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(phone_book[i], i);
        }
        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j)))
                    return false;
            }
        }

        // String.startsWith() 활용
        Arrays.sort(phone_book);
        for (int i = 0; i < len - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return answer;
    }
}
