package SWEA;

import java.util.Scanner;

public class D3_NQueens {

    static boolean[] flag_a;
    static boolean[] flag_b;
    static boolean[] flag_c;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            int n = sc.nextInt();
            count = 0;
            int result = queen(n);

            System.out.println("#" + test_case + " " + result);

        }
    }

    private static int queen(int n) {
        int result = 0;
        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 0;
        } else if (n == 3) {
            result = 0;
        } else {
            // 행 체크 배열, 대각선 체크 배열 2개
            flag_a = new boolean[n];
            flag_b = new boolean[n * 2]; //
            flag_c = new boolean[n * 2];

            set(n, 0);
            result = count;
        }

        return result;
    }

    // depth는 열을 의미하기도 함
    private static void set(int n, int depth) {
        if (depth == n) {
            count++;
            return;
        }

        // 열 탐색
        for (int i = 0; i < n; i++) {
            if (!flag_a[i] && !flag_b[depth + i] && !flag_c[i + n - depth]) {
                flag_a[i]= true;
                flag_b[depth + i] = true;
                flag_c[i + n - depth] = true;
                set(n, depth + 1);
                flag_a[i]= false;
                flag_b[depth + i] = false;
                flag_c[i + n - depth] = false;
            }
        }
    }

}
