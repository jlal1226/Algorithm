package SWEA;

import java.util.Scanner;

public class D3_InfiniteDictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            String P = sc.next();
            String Q = sc.next();

            int len = Math.min(P.length(), Q.length());

            boolean check = false;
            String result = null;

            // 단어 단순 비교
            for (int i = 0; i < len; i++) {
                int first = P.charAt(i) - 'a';
                int second = Q.charAt(i) - 'a';

                if (first < second) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                // 길이 차이가 1이면 -> a로 시작하면 단어 1개도 존재 안함 / a로 시작하지 않으면 최소 1개의 단어 존재
                if (Math.abs(Q.length() - P.length()) == 1 && Q.charAt(Q.length() - 1) == 'a') {
                    result = "N";
                } else {
                    result = "Y";
                }
                // 길이 차이가 1 이상이면 -> 최소 1개 이상의 단어가 P Q 사이에 존재
            } else {
                result = "Y";
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
