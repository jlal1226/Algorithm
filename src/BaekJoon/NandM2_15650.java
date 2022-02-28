package BaekJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM2_15650 {
    static boolean[] check;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        arr = new int[M];
        dfs(N, M, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int N, int M, int depth, int last) {
        if (depth == M) {
            for (int val : arr)
                sb.append(val).append(" ");
            sb.append("\n");
            return;
        }

        // 이미 배열에 들어간 값보다 큰 수에 대해서만 반복문 수행
        for (int i = last; i < N; i++)  {
            arr[depth] = i + 1;
            dfs(N, M, depth + 1, i + 1);
        }
    }
}
