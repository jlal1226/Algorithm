package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ColoringChessBoard_1018 {
    static int min = 64;
    public static void minNum (int cnt) {
        if (cnt < min)
            min = cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        // 2차원 배열 생성
        String[][] chess = new String[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                chess[i] = input.split("");
            }
        }
        // 시작이 B냐 W냐에 따라 홀수 짝수 다르게 판단하면 될듯?
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt = 0;
                if ( chess[i][j].equals("W")) {
                    // 8 * 8 검사
                    for (int k = i; k < 8 + i; k ++) {
                        for (int l = j; l < 8 + j; l++) {
                            if ( (k + l) % 2 == 0) {
                                if (chess[k][l].equals("B"))
                                    cnt++;
                            }else {
                                if (chess[k][l].equals("W"))
                                    cnt++;
                            }
                        }
                    }

                }else {
                    // 8 * 8 검사
                    for (int k = i; k < 8 + i; k ++) {
                        for (int l = j; l < 8 + j; l++) {
                            if ( (k + l) % 2 == 0) {
                                if (chess[k][l].equals("W"))
                                    cnt++;
                            }else {
                                if (chess[k][l].equals("B"))
                                    cnt++;
                            }
                        }
                    }
                    minNum(cnt);
                }
            }
        }
        if (min == 64) {
            System.out.println(0);
        }else {
            System.out.println(min);
        }
    }
}
