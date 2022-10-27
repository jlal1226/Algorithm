package SWEA;

import java.util.Scanner;
import java.util.StringTokenizer;

public class D2_RC_Car {
    /**
     * 초기 속도 : 0 m/s
     * 0 : 유지 / 1 : 가속 / 2 : 감속
     *
     * 1 2 -> 2 m/s 가속 -> 이동거리 2m
     * 현재 속도보다 감속할 속도가 더 클 경우, 속도 : 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            int N = sc.nextInt(); // 커맨드 개수
            int distance = 0;
            int v = 0;
            for (int i = 0; i < N; i++) {
                int cmd = sc.nextInt();
                if (cmd == 0) {
                    distance += v;
                    continue;
                }
                int inputV = sc.nextInt();

                switch (cmd) {
                    case 1:
                        v += inputV;
                        break;
                    case 2:
                        if (inputV > v) {
                            v = 0;
                        } else {
                            v -= inputV;
                        }
                    default:
                        break;
                }

                distance += v;
            }
            System.out.println("#"  + test_case + " " + distance);
        }
    }
}
