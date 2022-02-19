package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecompositionSum_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // n의 가장 작은 생성자를 구하시오
        boolean check = false;
        for (int i = 1; i < n; i++) {
            if (get(i) == n){
                System.out.println(i);
                check = true;
                break;
            }
        }
        if (!check)
            System.out.println(0);
    }

    public static int get(int n) {
        int result = n;
        int tmp = n;
        while (true) {
            if (tmp / 10 == 0) {
                result += tmp;
                break;
            }
            result += tmp % 10;
            tmp = tmp / 10;
        }
        return result;
    }
}
