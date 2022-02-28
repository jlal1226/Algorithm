package BaekJoon;

import java.io.*;

public class FibonacciDP_1003 {
    static StringBuilder sb = new StringBuilder();
    static int[][] memo;
    static Integer[][] memo_top_down = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        memo_top_down[0][0] = 1;
        memo_top_down[0][1] = 0;
        memo_top_down[1][0] = 0;
        memo_top_down[1][1] = 1;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            memo = new int[input + 1][2];
            fibo(input);
            System.out.println(fibo_top_down(input)[0] + " " + fibo_top_down(input)[1]);
        }
        bw.write(sb.toString());
        bw.close();
    }
    // bottom-up 방식
    static void fibo(int n) {
        if (n == 0) {
            memo[0][0] = 1;
        }else if (n == 1) {
            memo[1][1] = 1;
        } else {
            memo[0][0] = 1;
            memo[1][1] = 1;
            for (int i = 2; i <= n; i++) {
                memo[i][0] = memo[i-1][0] + memo[i-2][0];
                memo[i][1] = memo[i-1][1] + memo[i-2][1];
            }
        }
        sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
    }
    // top_down 방식 : 재귀적
    static Integer[] fibo_top_down(int n) {
        if (memo_top_down[n][0] == null || memo_top_down[n][1] == null) {
            memo_top_down[n][0] = fibo_top_down(n-1)[0] + fibo_top_down(n-2)[0];
            memo_top_down[n][1] = fibo_top_down(n-1)[1] + fibo_top_down(n-2)[1];
        }

        return memo_top_down[n];
    }
}
