package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663 {
    static boolean[] a;
    static boolean[] b;
    static boolean[] c;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a = new boolean[N]; // 열
        b = new boolean[(N * 2) - 1]; // 대각선
        c = new boolean[(N * 2) - 1]; // 대각선

        func(N, 0);
        System.out.println(cnt);

    }

    static void func(int N, int tmp) {
        for (int i = 0; i < N; i++) {
            if (!a[i] && !b[tmp + i] && !c[tmp - i + N - 1]) {
                if (tmp == N - 1) {
                    cnt++;
                }else {
                    a[i] = b[tmp + i] = c[tmp - i + N - 1] = true;
                    func(N,tmp + 1);
                    a[i] = b[tmp + i] = c[tmp - i + N - 1] = false;
                }
            }
        }
    }
}
