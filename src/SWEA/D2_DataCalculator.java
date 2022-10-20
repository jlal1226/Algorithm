package SWEA;

import java.util.Scanner;

public class D2_DataCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 31 / 31일 -> 21일 + 30일 + 28일 + 1일
        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            int month_1 = sc.nextInt() - 1;
            int day_1 = sc.nextInt();
            int month_2 = sc.nextInt() - 1;
            int day_2 = sc.nextInt();

            int sum = 0;
            for (int start = month_2; start >= month_1; start--) {
                sum += dates[start];
            }

            sum -= day_1 - 1;
            sum -= dates[month_2] - day_2;

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
