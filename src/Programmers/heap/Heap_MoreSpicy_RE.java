package Programmers.heap;

import java.util.*;
import java.util.stream.Collectors;

public class Heap_MoreSpicy_RE {
    public static void main(String[] args) {
        // {1, 2, 3, 9, 10, 12} -> 2
        // {1, 1, 1, 1, 1, 1} -> 5
        int[] s = {1, 1, 1, 1, 1, 1};
        int K = 7;
        System.out.println(solution(s, K));
    }

    public static int solution(int[] scoville, int K) {
        int count = 0;

        // 숫자가 낮은게 우선순위를 가짐
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : scoville) {
            q.add(i);
        }

        while (!q.isEmpty() && q.peek() < K) {
            if (q.size() == 1) {
                return -1;
            }
            int first = q.poll();
            int second = q.poll();
            q.add(first + (second * 2));

            count++;
        }

        return count;
    }
}
