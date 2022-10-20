package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMax_Sum {
    public static void main(String[] args) {
        //256741038 623958417 467905213 714532089 938071625
        List<Integer> arr = new ArrayList<>();
        arr.add(256741038);
        arr.add(623958417);
        arr.add(467905213);
        arr.add(714532089);
        arr.add(938071625);
        miniMaxSum(arr);
    }
    public static void miniMaxSum(List<Integer> arr) {
        // 배열에서 최소값 4개 / 최대값 4개의 합 출력

        Collections.sort(arr);

        long min = 0;
        long max = 0;

        for (int i = 0; i < 4; i++) {
            min += arr.get(i);
            max += arr.get(arr.size() - i - 1);
        }

        System.out.println(min + " " + max);
    }
}
