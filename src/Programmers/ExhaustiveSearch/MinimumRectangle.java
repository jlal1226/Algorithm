package Programmers.ExhaustiveSearch;

public class MinimumRectangle {
    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        };
        int result = solution(sizes);
        System.out.println(result);
    }

    /**
     * 모든 명함을 넣을 수 있는 최소 크기의 지갑은 만들어야됨
     * 명함은 회전 가능
     * 가로에 가장 큰 수를 넣기
     */

    public static int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0;
        int maxHeight = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] <= sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
            maxWidth = Math.max(sizes[i][0], maxWidth);
            maxHeight = Math.max(sizes[i][1], maxHeight);
        }

        answer = maxWidth * maxHeight;

        return answer;
    }
}
