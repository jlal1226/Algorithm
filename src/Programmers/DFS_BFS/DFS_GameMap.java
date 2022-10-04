package Programmers.DFS_BFS;

public class DFS_GameMap {
    /**
     * 캐릭터는 동서남북 방향으로 한칸씩 이동
     * n * m 크기의 사이즈
     * 0 : 벽 / 1 : 벽 없는 자리
     * 캐릭터는 항상 1,1 / 상대 진영은 우측 하단
     * 상대 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최소값을 구하시오
     *
     */
    public static void main(String[] args) {
        int maps[][] = {
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int solution = solution(maps);
        System.out.println(solution);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int result = Integer.MAX_VALUE;
    static int n, m;
    static int[][] board;

    public static int solution(int[][] maps) {
        // 종료 조건
        n = maps[0].length - 1;
        m = maps.length - 1;
        if (maps[m][n - 1] == 0 && maps[m - 1][n] == 0) {
            return -1;
        }

        board = maps.clone();
        // 탐색 시작
        search(1, 0, 0);
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    /**
     * 해당 문제를 DFS로 해결하면 시간 초과 문제 발생 -> 미로 찾기와 같은 최단 경로 문제는 BFS로 해결
     */

    private static void search(int depth, int x, int y) {
        if (x == m && y == n) {
            result = Math.min(depth, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if (check(nextX, nextY)) {
                if (board[nextX][nextY] == 1) {
                    board[nextX][nextY] = -1;
                    search(depth + 1, nextX, nextY);
                    board[nextX][nextY] = 1;
                }
            }
        }
    }

    private static boolean check(int x, int y) {
        boolean check = false;
        if (x >= 0 && x <= m && y >= 0 && y <= n) {
            check = true;
        }
        return check;
    }
}
