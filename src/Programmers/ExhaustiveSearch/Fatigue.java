package Programmers.ExhaustiveSearch;

public class Fatigue {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {
                {80,20}, {50,40}, {30,10}
        };
        System.out.println(solution(k, dungeons));
    }

    /**
     * 최소 피로도, 소모피로도
     *
     * 피로도 : k
     * 하루에 최대한 많은 던전을 탐험할 수 있는 던전 수
     */

    static boolean[] visited;
    static int len;
    static int result = -1;
    public static int solution(int k, int[][] dungeons) {
        len = dungeons.length;

        visited = new boolean[len];

        search(k, 0, dungeons);

        return result;
    }

    private static void search(int k, int depth, int[][] dungeons) {
        if (depth == len || k <= 0) {
            result = Math.max(result, depth);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                if (dungeons[i][0] <= k && k - dungeons[i][1] >= 0) {
                    visited[i] = true;
                    search(k - dungeons[i][1], depth + 1, dungeons);
                    visited[i] = false;
                }
            }
        }

        result = Math.max(result, depth);
    }

}
