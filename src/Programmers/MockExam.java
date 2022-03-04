package Programmers;

import java.util.Arrays;

public class MockExam {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        int[] result = solution(answers);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] answers) {
        int cnt_a = 0;
        int cnt_b = 0;
        int cnt_c = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer_a = (i + 1) % 5;
            if (answer_a == 0) {
                answer_a = 5;
            }
            int answer_b = 0;
            switch (i % 8) {
                case 1:
                    answer_b = 1;
                    break;
                case 3:
                    answer_b = 3;
                    break;
                case 5:
                    answer_b = 4;
                    break;
                case 7:
                    answer_b = 5;
                    break;
                default:
                    answer_b = 2;
                    break;
            }
            int answer_c = 0;
            switch (i % 10) {
                case 0:
                case 1:
                    answer_c = 3;
                    break;
                case 2:
                case 3:
                    answer_c = 1;
                    break;
                case 4:
                case 5:
                    answer_c = 2;
                    break;
                case 6:
                case 7:
                    answer_c = 4;
                    break;
                case 8:
                case 9:
                    answer_c = 5;
                    break;
            }

            if (answers[i] == answer_a) {
                cnt_a++;
            }
            if (answers[i] == answer_b) {
                cnt_b++;
            }
            if (answers[i] == answer_c) {
                cnt_c++;
            }
        }
        return result(cnt_a, cnt_b, cnt_c);
    }

    static int[] result(int a, int b, int c) {
        int[] result;
        int[] tmp = {a, b, c};
        int max = Math.max(a, Math.max(b, c));
        if (a == b && a == max) {
            if (b == c) {
                result = new int[3];
                result[0] = 1;
                result[1] = 2;
                result[2] = 3;
            } else {
                result = new int[2];
                result[0] = 1;
                result[1] = 2;
            }
        } else if (b == c && b == max) {
            result = new int[2];
            result[0] = 2;
            result[1] = 3;
        } else if (a == c && a == max) {
            result = new int[2];
            result[0] = 1;
            result[1] = 3;
        } else {
            result = new int[1];
            int maxIndex = 0;
            for (int i = 1; i < 3; i++) {
                if (tmp[maxIndex] < tmp[i]) {
                    maxIndex = i;
                }
            }
            result[0] = maxIndex + 1;
        }
        return result;
    }
}
