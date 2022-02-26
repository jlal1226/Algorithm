package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColoringChessBoard_1018 {
    static int min = 64;
    public static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') {
                    arr[i][j] = true; // W일때 true
                }else {
                    arr[i][j] = false; // B일때 false
                }
            }
        }
        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i,j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int cnt = 0;

        boolean TF = arr[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                if (arr[i][j] != TF) {
                    cnt++;
                }
                TF = (!TF); // 다음 칸은 다른색이여야함
            }
            TF = (!TF);
        }
        cnt = Math.min(cnt, 64 - cnt);

        min = Math.min(min, cnt);
    }
}
