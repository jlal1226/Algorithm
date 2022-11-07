package SWEA;

import java.util.Scanner;

public class D3_View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int T;
        //T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            // 코드 작성
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int result = 0;
            int leftMax = 0;

            for (int i = 2; i <= N - 3; i++) {
                if (test_case == 3 && result == 8994) {
                    System.out.println("check");
                }
                if (arr[i] > arr[i + 1]) {
                    if (arr[i] > arr[i + 2]) {
                        if (arr[i] <= leftMax) {
                            leftMax = Math.max(arr[i - 1], arr[i]);
                            continue;
                        }
                        // 3칸 이동
                        int rightMax = Math.max(arr[i + 1], arr[i + 2]);
                        result += arr[i] - Math.max(leftMax, rightMax);
                        i += 2;
                        leftMax = rightMax;
                    } else { // 2칸 이동
                        leftMax = Math.max(arr[i + 1], arr[i]);
                        i += 1;
                    }
                } else {
                    // 1칸 이동
                    leftMax = Math.max(arr[i-1], arr[i]);
                }
            }
            // N - 3 N -2 구역

            System.out.println("#" + test_case + " " + result);
        }
    }
}
