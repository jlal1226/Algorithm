package Programmers;

import java.util.Arrays;

public class H_Index_Sort {
    public static void main(String[] args) {
        int[] arr = {1000,1000,1000,1000,1000};
        System.out.print(solution(arr));
    }
    // 1, 1, 1, 0, 0
    public static int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = n; i >= 0; i--) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) { // 큰 수 부터 탐색
                if (citations[j] < i) {
                    break;
                }
                if (count > i) {
                    break;
                }
                count++;
            }
            if (i <= count) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}
