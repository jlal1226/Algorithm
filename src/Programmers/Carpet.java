package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        int[] result = solution(brown,  yellow);
        System.out.print(Arrays.toString(result));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        List<Integer> list = new ArrayList <>();
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int row = list.get(i) + 2;
            int col = yellow / list.get(i) + 2;
            if (row * col == total) {
                answer[0] = col;
                answer[1] = row;
            }
        }

        return answer;
    }
}
