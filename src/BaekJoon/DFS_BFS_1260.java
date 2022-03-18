package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_1260 {
    static ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
    static int N;
    static int M;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 노드
        visited = new boolean[N + 1];

        // 정점의 개수 많큼 list 생성 후 list에 삽입 -> 0번째 인덱스 : Dummy Data
        for(int i=0; i<N + 1; i++) {
            adList.add(new ArrayList<Integer> ());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adList.get(v1).add(v2);
            adList.get(v2).add(v1);
        }
        // 자식노드 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adList.get(i));
        }
/*

        //인접리스트 출력
        for(int i=1; i<=N; i++) {
            Iterator<Integer> iter = adList.get(i).iterator();
            System.out.print("[" + i + "]: ");

            while (iter.hasNext()) {
                System.out.print(iter.next() + " ");
            }
            System.out.println();

        }
*/

        dfs(V);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(V);
        System.out.print(sb);
    }

    static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        sb.append(start).append(" ");
        ArrayList<Integer> subList = adList.get(start);
        for (Integer integer : subList) {
            dfs(integer);
        }
    }
    // 큐를 활용한 BFS 구현
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true; // 방문 처리

        while (!q.isEmpty()) {
            int tmp = q.poll();
            sb.append(tmp).append(" ");
            for (int i : adList.get(tmp)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
