package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindPrimeNum_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean check = true;
            if (num < 2)
                check = false;
            for (int j = 2; j*j <= num; j++){
                if (num % j == 0) { // 소수가 아니면
                    check = false;
                    break;
                }
            }
            if(check)
                cnt++;
        }
        System.out.println(cnt);
    }
}
