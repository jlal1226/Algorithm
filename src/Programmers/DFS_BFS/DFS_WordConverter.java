package Programmers.DFS_BFS;

import java.util.Arrays;

public class DFS_WordConverter {
    public static void main(String[] args) {
        //
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target = "cog";
        System.out.println(solution(begin, target, words));
        System.out.println(check(1, "hit", "hot"));
    }

    /**
     * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
     * 2. words에 있는 단어로만 변환할 수 있습니다.
     */
    static int min;
    static boolean[] visited;

    public static int solution(String begin, String target, String[] words) {
        min = words.length + 1;
        visited = new boolean[words.length];
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        dfs(0, begin, target, words);

        return min;
    }

    public static void dfs(int depth, String begin, String target, String[] words) {
        if (begin.equals(target)) {
            if (depth < min) {
                min = depth;
            }
        }
        for (int i = 0; i < begin.length(); i++) {
            for (int j = 0; j < words.length; j++) {
                if (!visited[j] && check(i, begin, words[j])) {
                    visited[j] = true; // 방문 처리
                    dfs(depth + 1, words[j], target, words);
                    visited[j] = false;
                }
            }
        }
    }

    // 단어 체크
    public static boolean check(int index, String begin, String check) {
        String prev = begin.substring(0, index);
        String next = begin.substring(index + 1, begin.length());
        check = check.substring(0, index) + check.substring(index + 1, check.length());

        return check.contains(prev + next);
    }
}
