package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum_Re {
    public static void main(String[] args) {
        int[] numbers = {0,0,0,0};
        System.out.println(solution(numbers));
    }
    public static String solution(int[] numbers) {
        String answer = "";
        // 0,0,0,0 -> 0
        // 앞자리 수가 큰 수를 기준으로 정렬?
        int len = numbers.length;
        String[] strNum = new String[len];
        int tmp = 0;
        for (int n : numbers) {
            strNum[tmp++] = String.valueOf(n);
        }
        Arrays.sort(strNum, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        if (strNum[len - 1].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(strNum[i]);
        }


        return sb.toString();
    }
}
