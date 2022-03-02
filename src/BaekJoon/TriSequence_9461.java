package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriSequence_9461 {
    static long[] arr = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        for (int i = 6; i < 101; i++) {
            arr[i] = -1;
        }
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(func(n)).append("\n");
        }
        System.out.println(sb);
    }

    static long func(int n) {
        if (n > 5) {
            if (arr[n] == -1) {
                return arr[n] = func(n-1) + func(n-5);
            }
        }
        return arr[n];
    }
}
