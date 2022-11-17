package SWEA;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D3_Flatten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        //T = sc.nextInt();

        for (int test_case = 1; test_case <= 10; test_case++) {
            // 코드 작성
            int n = sc.nextInt();

            PriorityQueue<Integer> asceQueue = new PriorityQueue<>(); // 오름차순 우선순위 큐
            PriorityQueue<Integer> descQueue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 우선순위 큐

            for (int i = 0; i < 100; i++) {
                int input = sc.nextInt();
                asceQueue.add(input);
                descQueue.add(input);
            }
            int result = 0;

            for (int i = 0; i < n; i++) {
                int max = descQueue.poll();
                int min = asceQueue.poll();

                if (max == min) {
                    result = 0;
                }

                descQueue.add(max - 1);
                asceQueue.add(min + 1);
            }

            result = descQueue.peek() - asceQueue.peek();

            System.out.println("#" + test_case + " " + result);
        }
    }
}
