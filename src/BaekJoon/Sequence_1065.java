package BaekJoon;

import java.util.Scanner;

public class Sequence_1065 {
    static int func(int n) {
        int cnt = 0; // 1 ~ 99까지 모두 한수
        if (n < 100){
            return n;
        }else{ // 3자리 수
            cnt = 99;
            if (n > 1000)
                n = 999;
            // 100 ~ 1000를 고려하면 됌
            for (int i = 100; i <= n; i++ ) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if((hun - ten) == (ten - one))
                    cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int result = func(input);
        System.out.println(result);
    }
}
