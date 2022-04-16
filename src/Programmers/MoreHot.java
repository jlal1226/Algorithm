package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreHot {
    public static void main(String[] args) {
        int[] s = {1, 1, 1, 1, 1, 1};
        int k = 7;
        int result = solution(s, k);
        System.out.println(result);
    }
    public static int solution(int[] scoville, int K) {

        // 배열의 최소값과 다음 최소값을 구한다.
        // 값을 구해서 힙에 삽입 -> 삽입 과정은 분리
        // 삽입하면 최소힙을 유지해야됌

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int count = 0;
        for (int i : scoville) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            if (q.size() == 1 && q.peek() < K) {
                return -1;
            }
            if (q.peek() >= K) {
                break;
            }
            int first = q.poll();
            if (q.peek() == null) {
                break;
            }
            int second = q.poll();
            q.add(first + second * 2);
            count++;
        }
        return count;
    }
}
