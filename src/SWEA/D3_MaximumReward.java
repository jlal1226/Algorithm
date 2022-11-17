package SWEA;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class D3_MaximumReward {

    static int[] arr;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            // 코드 작성
            String str = sc.next();
            arr = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
            int n = sc.nextInt();
            max = 0;

            search(0, n, 0);

            System.out.println("#" + test_case + " " + max);
        }
    }

    public static void search(int depth, int n, int k) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int value : arr) {
                sb.append(value);
            }
            max = Math.max(max, Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = k; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    swap(i, j);
                    search(depth + 1, n, i);
                    swap(i, j);
                }
            }
        }
    }

    public static void search1(int depth, int n) {
        if (depth == n) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap(i, j);
                    search1(depth + 1, n);
                    swap(i, j);
                }
            }
        }
    }

    public static void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
