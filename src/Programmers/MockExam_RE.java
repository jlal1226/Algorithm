package Programmers;

import java.util.*;

public class MockExam_RE {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        int[] answers1 = {1,3,2,4,2};
        solution(answers1);
    }
    public static int[] solution(int[] answers) {
        // 1번 수포자 -> 5개 : 1,2,3,4,5
        // 2번 수포자 -> 8개 : 2,1, 2,3, 2,4, 2,5
        // 3번 수포자 -> 10개 : 3,3, 1,1, 2,2, 4,4, 5,5

        int[] a = {1,2,3,4,5};
        int[] b = {2,1, 2,3, 2,4, 2,5};
        int[] c = {3,3, 1,1, 2,2, 4,4, 5,5};
        int cnt_a = 0, cnt_b = 0, cnt_c = 0;

        for (int i = 0; i < answers.length; i++) {
            if (a[i%5] == answers[i]) {
                cnt_a++;
            }
            if (b[i%8] == answers[i]) {
                cnt_b++;
            }
            if (c[i%10] == answers[i]) {
                cnt_c++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int max = Math.max(cnt_a, Math.max(cnt_b, cnt_c));
        if (max == cnt_a)
            list.add(1);
        if (max == cnt_b)
            list.add(2);
        if (max == cnt_c)
            list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
