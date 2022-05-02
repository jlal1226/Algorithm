package Programmers;

import java.util.Arrays;

public class Greedy_JoyStick {
    public static void main(String[] args) {
        String name = "JAN";
        int result = solution(name);
        System.out.println(result);
    }

    /**
     * 알파벳 갯수 : 26개 (0 ~ 25)
     * A 연속성 확인 필요
     * N은 앞뒤 횟수 같음
     */

    public static int solution(String name) {
        int answer = 0;
        int len = name.length();
        check(name);
        for (int i = 0; i < len; i++) {
            // 중간에 A 있는 경우
            if (i < len - 1 && name.charAt(i + 1) == 'A') {

            }

            char c = name.charAt(i);
            int move = (c > 'N') ? 26 - (c - 'A') : c - 'A';
            System.out.println(move);
            answer += move;

            // 종료
            if (i == len - 1) {
                break;
            }

            // 커서 이동
            answer++;
        }

        return answer;
    }

    public static void check(String name) {
        int cnt = 0;

        // A의 연속성 판단
        // BBBBAAAAABBA
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
