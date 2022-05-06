package Programmers;

import java.util.LinkedList;
import java.util.Stack;

public class DFS_Network {
    public static void main(String[] args) {
        // {{1,1,0}, {1,1,1}, {0,1,1}}
        // {{1,1,0}, {1,1,0}, {0,0,1}}
        // {{1,1,1,0}, {1,1,1,0}, {1,1,1,0}, {0,0,0,1}} -> 2
        int[][] computers = {{1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}};
        int n = 4;
        int result = solution2(n, computers);
        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        LinkedList<Integer>[] graph = new LinkedList[n];
        boolean[] visited = new boolean[n];
        // 그래프 생성
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        // 노드 연결
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].addFirst(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i); // 0부터 시작

                // DFS 탐색
                while (!stack.isEmpty()) {
                    int v = stack.pop();
                    if (!visited[v]) {
                        visited[v] = true; // 방문 처리
                        for (int j = 0; j < graph[v].size(); j++) {
                            int destination = graph[v].get(j);
                            if (!visited[destination])
                                stack.push(destination);
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }

    // 재귀 호출로 구현하기
    public static int solution2(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // dfs
                dfs(visited, computers, n, i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(boolean[] visited, int[][] computers, int n, int target) {
        visited[target] = true;
        for (int i = 0; i < n; i++) {
            if (computers[target][i] == 1 && !visited[i]) {
                dfs(visited, computers, n, i);
            }
        }

    }
}
