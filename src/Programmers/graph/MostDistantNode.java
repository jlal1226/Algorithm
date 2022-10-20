package Programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MostDistantNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = solution(n, edge);
        System.out.println(result);
    }

    static boolean[] visited;
    static int[] values;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n + 1];
        values = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            values[i] = 99999;
        }
        // 그래프 생성

        // n+1개의 노드 생성 -> 0번째는 무시
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        // 탐색
        /**
         * 1번부터 시작
         * 가장 먼 노드 : 최단 경로로 이동했을 때 간선의 개수가 가장 많은 노드들
         * 1을 제외한 나머지 노드에 최단 경로로 가는 모든 경우의 수를 구해서 저장
         */
        //getPath(graph.get(1), 0);
        bfsSearch();
        System.out.println(Arrays.toString(values));
        Arrays.sort(values);

        int max = 0;
        for (int i = n; i > 1; i--) {
            if (values[i] < 99999) {
                max = values[i];
                break;
            }
        }

        if (max == 0) {
            return 0;
        } else if (max < 99999) {
            for (int i : values) {
                if (max == i) {
                    answer++;
                }
            }
        }


        return answer;
    }

    //bfs로 구현
    public static void bfsSearch() {
        Queue<Integer> q = new LinkedList();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();

            ArrayList<Integer> nodeList = graph.get(tmp);
            for (int i = 0; i < nodeList.size(); i++) {
                if (!visited[nodeList.get(i)]) {
                    visited[nodeList.get(i)] = true;
                    q.add(nodeList.get(i));
                    values[nodeList.get(i)] = values[tmp] + 1;
                }
            }
        }

    }

    // 최단 경로 메서드
    // dfs로 구현
    public static void getPath(ArrayList<Integer> initNode, int distance) {
        // 시작점 : 1번
        // 도착점 : dest

        // 1번과 연결된 노드를 찾는다
        // 목적지인지 확인 후 최소 간선 수 저장
        // 노드에 연결된 또 다른 노드를 찾는다
        if (initNode.size() == 0) {
            return;
        } else {
            for (int i = 0; i < initNode.size(); i++) {
                if (distance + 1 < values[initNode.get(i)]) {
                    values[initNode.get(i)] = distance + 1;
                }

            }
        }
        for (int i = 0; i < initNode.size(); i++) {
            int index = initNode.get(i);
            if (distance + 1 > values[index]) {
                continue;
            }
            if (!visited[index]) {
                visited[index] = true;
                getPath(graph.get(index), distance + 1);
                visited[index] = false;
            }
        }

    }
}
