package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-1);
        arr.add(-1);
        arr.add(0);
        arr.add(3);
        arr.add(3);

        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        // 양수, 음수, 0의 비율 출력
        // 소수점 6자리까지 처리

        int size = arr.size();
        double plus = 0;
        double minus = 0;
        double zero = 0;

        for (int n : arr) {
            if (n > 0) {
                plus++;
            } else if (n < 0) {
                minus++;
            } else {
                zero++;
            }
        }
        plus = plus / size;
        minus /= size;
        zero /= size;
        System.out.printf("%.6f\n", plus);
        System.out.printf("%.6f\n", minus);
        System.out.printf("%.6f", zero);
    }
}
