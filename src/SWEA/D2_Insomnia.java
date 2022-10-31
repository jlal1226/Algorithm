package SWEA;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D2_Insomnia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            String n = sc.next();
            int input = Integer.parseInt(n);
            int cnt = 2;
            Set<Integer> set = new HashSet<>();

            while (true) {
                for (int i = 0; i < n.length(); i++) {
                    int value = n.charAt(i) - '0';
                    set.add(value);
                }

                if (set.size() == 10) {
                    break;
                }
                n = Integer.toString(input * cnt++);
            }

            System.out.println("#" + test_case + " " + n);
        }
    }
}
