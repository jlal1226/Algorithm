package SWEA;

import java.util.Scanner;

public class D2_Factorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] arr = {2, 3, 5, 7, 11};
        for (int test_case = 1; test_case <= T; test_case++) {
            // 2 3 5 7 11
            StringBuilder sb = new StringBuilder();

            int num = sc.nextInt();

            for (int i = 0; i < 5; i++) {
                int cnt = 0;
                while (true) {
                    if (num % arr[i] != 0) {
                        break;
                    }
                    num /= arr[i];
                    cnt++;
                }
                sb.append(cnt).append(" ");
            }
            System.out.print("#" + test_case + " ");
            System.out.println(sb);
        }
    }
}
