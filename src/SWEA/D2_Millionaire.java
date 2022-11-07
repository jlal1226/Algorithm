package SWEA;

import java.util.*;

public class D2_Millionaire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        /**
         * 사재기 조건
         * 연속된 n일 동안의 물건의 매매가를 예측하여 알고 있다.
         * 하루에 최대 1개 구매 가능
         * 판매는 언제든지 가능
         * 1 -> 3 2원 이득
         * 2 -> 3 1원 이득
         * 3 -> 판매 총 3원 이득
         *
         * 구간별 최고점을 구한다.
         */
        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            long result = 0;
            int maxValue = arr[n - 1];

            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] <= maxValue) {
                    result += maxValue - arr[i];
                } else {
                    maxValue = arr[i];
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
