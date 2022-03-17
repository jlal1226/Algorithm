package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuadTree_1992 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        quadTree(N, 0, 0);
        System.out.print(sb);
    }

    static void quadTree(int N, int row, int col) {

        if (check(N, row, col)) {
            if (arr[row][col] == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            return;
        }

        if (N == 1) {
            sb.append(arr[row][col]);
            return;
        }
        int size = N / 2;
        int count = 0;
        for (int i = row; i < row + N; i += size) {
            for (int j = col; j < col + N; j += size) {
                count++;
                if (count == 1) {
                    sb.append("(");
                }
                quadTree(size, i, j);
                if (count == 4) {
                    sb.append(")");
                }

            }
        }
    }

    static boolean check(int size, int row, int col){
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
