package Programmers.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int r,c;
    int distance;

    public Node(int r, int c, int distance) {
        this.r = r;
        this.c = c;
        this.distance = distance;
    }
}

public class BFS_GameMap {
    public static void main(String[] args) {
        int maps[][] = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        int solution = solution(maps);
        System.out.println(solution);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    public static int solution(int[][] maps) {
        int answer = -1;

        n = maps[0].length - 1;
        m = maps.length - 1;
        boolean[][] visited = new boolean[m + 1][n + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0,0, 1));
        visited[0][0] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.r == m && node.c == n) {
                return node.distance;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + node.r;
                int nextY = dy[i] + node.c;

                if (check(nextX, nextY)) {
                    if (maps[nextX][nextY] == 0) {
                        continue;
                    }
                    if (!visited[nextX][nextY]) {
                        distance += 1;
                        queue.add(new Node(nextX, nextY, node.distance + 1));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return answer;
    }

    private static boolean check(int r, int c) {
        boolean check = false;
        if (r >= 0 && r <= m && c >= 0 && c <= n) {
            check = true;
        }
        return check;
    }
}
