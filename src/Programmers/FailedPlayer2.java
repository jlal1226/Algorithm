package Programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FailedPlayer2 {

    public static void main(String[] args) {
        // "mislav", "stanko", "mislav", "ana"
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "mislav", "ana"};
        String answer = solution(p, c);
        System.out.println(answer);
    }

    static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (int i = 0; i < map.size(); i++) {
            if (map.get(participant[i]) > 0) {
                return participant[i];
            }
        }

        return "";
    }
}
