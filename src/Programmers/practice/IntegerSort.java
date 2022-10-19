package Programmers.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSort {
    public static void main(String[] args) {
        long n = 1236921;
        System.out.println(solution(n));
    }
    public static long solution(long n) {
        long answer = 0;

        String str = String.valueOf(n);
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        Collections.sort(list, (o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            sb.append(c);
        }

        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
