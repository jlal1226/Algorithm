package Programmers.DFS_BFS;

public class DFS_TargetNum_RE {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 2;
        int result = solution(numbers, target);
        System.out.println(result);
    }
    static int answer = 0;
    public static int solution(int[] numbers, int target) {

        func(0, numbers, target, 0);

        return answer;
    }

    public static void func(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        func(depth + 1, numbers, target, sum + numbers[depth]);
        func(depth + 1, numbers, target, sum - numbers[depth]);
    }
}
