package Programmers;

import java.util.*;

public class Greedy_LifeBoat {
    public static void main(String[] args) {
        // 70, 50, 80, 50
        // 180, 170, 160, 155,80, 50, 50, 40
        // 100, 100, 100, 100
        // 200, 150, 50, 140, 60, 50, 50, 120
        int[] people = {100,500,500,900,950};
        int limit = 1000;
        int result = solution(people, limit);
        System.out.println(result);
    }
    public static int solution(int[] people, int limit) {
        int answer = 0;

        int lpt = 0; // 왼쪽 포인터
        int rpt = people.length - 1; // 오른쪽 포인터

        // 오름차순 정렬
        Arrays.sort(people);
        int count = 0;
        while (lpt <= rpt) {
            int min = people[lpt];
            while (people[rpt] > limit - min && rpt > lpt) {
                rpt--;
                count++;
            }
            lpt++;
            rpt--;
            count++;

        }
        return count;
    }

    public static int solution1(int[] people, int limit) {
        int answer = 0;

        List<Integer> peopleList = new ArrayList<>();
        for (int i : people) {
            peopleList.add(i);
        }
        // 오름차순 정렬
        Collections.sort(peopleList);

        for (int i = peopleList.size() - 1; i >= 0; i--) {
            int tmp = peopleList.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (tmp + peopleList.get(j) <= limit) {
                    peopleList.set(i, tmp + peopleList.get(j));
                    peopleList.remove(j);
                    break;
                }
            }
        }

        return peopleList.size();
    }
}
