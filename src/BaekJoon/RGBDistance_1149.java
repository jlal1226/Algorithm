package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance_1149 {
    static int[][] arr = new int[1001][3];
    static int[][] dp = new int[1001][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];

        int result = Math.min(func(N, 0), Math.min(func(N, 1), func(N, 2)));
        System.out.println(result);
    }

    static int func(int N, int color) {
        if (N == 1) {
            return dp[N][color];
        }
        if (dp[N][color] == 0) {
            if (color == 0) {
                dp[N][color] = Math.min(func(N-1, 1), func(N-1, 2)) + arr[N][0];
            } else if (color == 1) {
                dp[N][color] = Math.min(func(N-1, 0), func(N-1, 2)) + arr[N][1];
            } else if (color == 2) {
                dp[N][color] = Math.min(func(N-1, 0), func(N-1, 1)) + arr[N][2];
            }
        }
        return dp[N][color];
    }
}
