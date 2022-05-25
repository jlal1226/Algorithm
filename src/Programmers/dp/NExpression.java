package Programmers.dp;

public class NExpression {
    public static void main(String[] args) {

    }

    public int solution(int N, int number) {
        int answer = 0;

        /**
         * N = 2 / number = 11
         * 22 / 2
         * 2 + 2 + 2 + 2 + 2 + (2 / 2)
         * (2 / 2) + ... + (2 / 2)
         *
         * (22 + 2) / 2 = 12
         * (22 + 2 + 2) / 2 = 13
         *
         * 1. 1개를 쓰는 경우
         * 2. N을 2번쓰는 사칙 연산 + NN인 경우
         * 3. N 1개, N 2개 사칙연산 + NNN인 경우
         */
        return answer;
    }
}
