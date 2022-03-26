package Programmers;

import java.io.IOException;
import java.util.*;

public class LargestNum {
    public static void main(String[] args) throws IOException {
        int[] numbers1 = {3, 30, 340, 5, 9, 20, 110, 50, 56, 1, 0};
        int[] numbers2 = {6, 10, 2};
        String result = solution(numbers1);
        System.out.print(result);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] strNum = new String[numbers.length];
        int index = 0;
        for (int n : numbers) {
            strNum[index++] = String.valueOf(n);
        }
        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        System.out.println(Arrays.toString(strNum));

        for (int i = strNum.length - 1; i >= 0; i--) {
            sb.append(strNum[i]);
        }
        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        return answer;
    }
}
