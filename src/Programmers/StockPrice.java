package Programmers;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] p = {2, 1, 2, 2, 2, 3};
        int[] result = solution(p);
        System.out.print(Arrays.toString(result));
    }
    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[i] <= prices[j]) {
                    answer[i]++;
                }else {
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
}
