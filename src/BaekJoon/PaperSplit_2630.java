package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperSplit_2630 {
    static int[][] arr;
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);

    }

    static void paper(int N, int row, int col) {
        if(check(N, row, col)) {
            if (arr[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        // 크기가 1인경우 종료
        if (N == 1) {
            if (arr[row][col] == 1) {
                blue += 1;
            } else {
                white += 1;
            }
            return;
        }

        int size = N / 2;
        // 1,2,3,4 분면으로 검사

        paper(size, row, col);
        paper(size, row + size, col);
        paper(size, row, col + size);
        paper(size, row + size, col + size);
    }

    static boolean check(int N, int row, int col) {
        boolean state = true;
        int color = arr[row][col];
        for (int i = row; i < row + N; i++) {
            for (int j = col; j < col + N; j++) {
                if (color != arr[i][j])
                    state = false;
            }
        }
        return state;
    }
}
