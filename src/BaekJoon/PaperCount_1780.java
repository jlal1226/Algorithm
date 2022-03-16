package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperCount_1780 {
    static int a = 0;
    static int b = 0;
    static int c = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paperCount(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(a).append("\n");
        sb.append(b).append("\n");
        sb.append(c);

        System.out.print(sb);
    }

    static void paperCount(int N, int row, int col) {
        if (check(N, row, col)) {
            count(arr[row][col]);
            return;
        }

        int size = N /3;
        for (int i = row; i < row + N; i += size) {
            for (int j = col; j < col + N; j += size) {
                paperCount(size, i, j);
            }
        }
    }

    static void count(int n) {
        if (n == -1) {
            a += 1;
        } else if (n == 0) {
            b += 1;
        } else {
            c += 1;
        }
    }

    static boolean check(int size, int row, int col) {
        // -1, 0, 1 비교
        int tmp = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (tmp != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
