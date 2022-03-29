package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] p = {93, 30, 5};
        int[] s = {1, 30, 5};
        int[] p1 = {95, 90, 99, 99, 80, 99};
        int[] s1 = {1, 1, 1, 1, 1, 1};
        int[] p2 = {99, 99, 99, 99, 99};
        int[] s2 = {99, 99, 99, 99, 99};
        int[] p3 = {20, 99, 93, 30, 55, 10};
        int[] s3 = {50, 10, 1, 1, 30, 5};
        int[] p4 = {1, 2, 1};
        int[] s4 = {100, 100, 100};

        solution(p3,s3);
        NewSolution(p,s);
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> pList = new ArrayList<>();
        ArrayList<Integer> sList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            pList.add(progresses[i]);
            sList.add(speeds[i]);
        }

        while (!pList.isEmpty()) {
            for (int i = 0; i < pList.size(); i++) {
                int tmp = pList.get(i);
                if (tmp >= 100) {
                    continue;
                }
                pList.set(i, tmp + sList.get(i));
            }
            // 맨 앞 요소가 100이하면 continue
            if (pList.get(0) < 100) {
                continue;
            }
            // pList에서 100이상 값 요소 삭제
            int count = 0;
            while (!pList.isEmpty()) {
                int tmp = pList.get(0);
                if (tmp < 100) {
                    break;
                }
                pList.remove(0);
                sList.remove(0);
                count++;
            }
            if (count != 0) {
                result.add(count);
            }

        }
        System.out.print(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // 수학적 접근 방법
    public static int[] NewSolution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++; // 작업이 끝나는 날을 저장함
        }
        // 0이 아닌 요소들을 filter()로 제거
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }

}
