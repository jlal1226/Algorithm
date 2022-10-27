package SWEA;

import java.util.*;

public class D2_Unzip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        /**
         * 3
         * A 5
         * B 7
         * C 8
         *
         */

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            Queue<Character> queue = new LinkedList<>();
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                String input = sc.next();
                int cnt = sc.nextInt();

                for (int j = 0; j < cnt; j++) {
                    queue.add(input.charAt(0));
                }

            }
            System.out.println("#" + test_case);
            int tmp = 0;
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                if (tmp % 10 == 0 && tmp != 0) {
                    System.out.println(sb);
                    sb = new StringBuilder();
                }
                sb.append(queue.poll());
                tmp++;
            }
            System.out.println(sb);


        }
    }
}
