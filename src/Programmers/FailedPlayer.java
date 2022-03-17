package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FailedPlayer {
    public static void main(String[] args) {
        String[] a = {"leo", "kiki", "eden"};
        String[] b = {"eden", "kiki"};
        solution(a, b);
    }

    static String solution(String[] participant, String[] completion) {
        String answer = "";
        Set<String> set1 = new HashSet<>(Arrays.asList(participant));
        Set<String> set2 = new HashSet<>(Arrays.asList(completion));

        for (String s : set1) {
            String str = String.valueOf(s);
            if (!set2.contains(str)) {
                answer = str;
            }
        }

        return answer;
    }
}
