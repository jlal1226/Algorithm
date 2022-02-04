package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNum_2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = n;
        for(int i = m; i <= n; i++) {
            boolean check = true;
            if(i < 2) {
                check = false;
                continue;
            }
            for(int j = 2; j*j <= i; j++){
                if (i % j == 0) // 소수 아니면
                    check = false;
            }
            if(check) {
                sum += i;
                if (i <= min)
                    min = i;
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
