package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class D3_Harvesting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            int n = sc.nextInt();

            int total = 0;

            if (n == 1) {
                total = sc.nextInt();
            } else {
                int[][] board = new int[n][n];

                for (int i = 0; i < n; i++) {
                    String input = sc.next();
                    int[] arr = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
                    board[i] = arr;
                }

                // 상부
                for (int i = 0; i <= n / 2; i++) {
                    for (int j = n / 2 - i; j <= n / 2 + i; j++) {
                        total += board[i][j];
                    }
                }
                // 하부
                for (int i = n / 2 + 1; i < n; i++) {
                    int start = i - n / 2;
                    int end = (n - i) * 2 - 1 + start - 1;

                    for (int j = start; j <= end; j++) {
                        total += board[i][j];
                    }
                }
            }

            System.out.println("#" + test_case + " " + total);
        }
    }
}
