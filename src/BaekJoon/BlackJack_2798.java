package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack_2798 {
    // n장의 카드 -> 숫자 M을 외침
    // 3장의 카드를 골라야됌 -> M보다 작지만 최대한 가까운 조합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        String input[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int sum = 0;
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if (sum <= m && result <= sum)
                        result = sum;
                }
            }
        }

        System.out.println(result);
    }
}
