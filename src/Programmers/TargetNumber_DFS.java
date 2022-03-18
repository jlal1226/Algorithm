package Programmers;

public class TargetNumber_DFS {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr= {4, 1, 2, 1};
        int result = solution(arr, 4);
        System.out.println(result);
    }
    public static int solution(int[] numbers, int target) {

        dfs(0, numbers, target, 0);
        int answer = count;
        return answer;
    }

    public static void dfs(int depth, int[] nums, int target, int sum) {
        // 종료 조건
        if (depth == nums.length) {
            if (target == sum) {
                count += 1;
            }
        }else {
            dfs (depth + 1, nums, target, sum + nums[depth]);
            dfs (depth + 1, nums, target, sum - nums[depth]);
        }

    }
}
