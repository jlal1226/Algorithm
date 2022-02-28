package Example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensPuzzle {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int cnt = 0;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 8;
        queen(0);
        System.out.println(cnt);
    }

    static void queen(int i) {
        // i : 열, j : 행
        for(int j = 0; j < 8; j++){
            // 행, 대각선 2개에 겹치지 않도록
            if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
                if (i == 7) {
                    cnt++;
                } else {
                    flag_a[j] = flag_b[i+j] = flag_c[i - j + 7] = true;
                    queen(i + 1);
                    flag_a[j] = flag_b[i+j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }
}
