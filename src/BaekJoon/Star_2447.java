package BaekJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star_2447 {
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        func(N, 0, 0, false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void func(int N, int x, int y, boolean blank) {
        // 종료 조건
        if (blank)  {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[x][y] = '*';
            return;
        }
        int size = N / 3;
        int count = 0;

        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) {
                    func(size, i, j, true);
                } else{
                    func(size, i, j, false);
                }
            }
        }
    }
}
