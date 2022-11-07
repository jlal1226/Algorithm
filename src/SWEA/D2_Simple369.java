package SWEA;

import java.util.Scanner;

public class D2_Simple369 {
    /**
     * 35 -> -
     * 36 -> --
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();


        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (i < 10) {
                if (i % 3 == 0) {
                    result.append("-");
                } else {
                    result.append(i);
                }
            } else {
                String str = String.valueOf(i);
                boolean check = false;
                for (int j = 0; j < str.length(); j++) {
                    int tmp = str.charAt(j) - '0';
                    if (tmp != 0 && tmp % 3 == 0) {
                        result.append("-");
                        check = true;
                    }
                }
                if (!check) {
                    result.append(i);
                }
            }
            result.append(" ");
        }
        System.out.println(result);
    }
}
