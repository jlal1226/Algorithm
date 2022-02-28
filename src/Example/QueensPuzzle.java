package Example;

public class QueensPuzzle {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int cnt = 0;
    public static void main(String[] args) {
        queen(0);
        System.out.println(cnt);
    }

    static void queen(int i) {
        /*
        [ 백트랙킹 알고리즘 ] -> 특정 조건을 만족하는 모든 경우의 수를 검색하는 알고리즘 (가지치기)
        1. 각 열에 퀸을 1개만 배치한다.
        2. 각 행에 퀸을 1개만 배치한다.
        3. 왼쪽 대각선 방향, 오른쪽 대각선 방향으로 겹치지 않는다.
         */
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
