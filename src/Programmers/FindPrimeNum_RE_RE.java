package Programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FindPrimeNum_RE_RE {
    public static void main(String[] args) {
        solution("002");
        System.out.println(result);
    }
    static int strLen;
    static int result = 0;
    static Set<Integer> list = new HashSet<>();
    public static int solution(String numbers) {
        int answer = 0;
        strLen = numbers.length();

        // 모든 조합을 구한다 -> HashSet 중복 제거
        permutation("", numbers);

        // 소수 판별 후 count
        for (int i : list) {
            if (isPrime(i)) {
                result++;
                System.out.println(i);
            }
        }

        return result;
    }

    public static void permutation(String chosen, String str) {
        if (!Objects.equals(chosen, "")) {
            list.add(Integer.parseInt(chosen));
        }
        // 종료 조건
        if (chosen.length() == strLen) {
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String str1 = chosen + str.charAt(i);
            String str2 = str.substring(0, i) + str.substring(i + 1, str.length());
            permutation(str1, str2);
        }
    }

    // 소수 판별
    public static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num < 2 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) { // 2의 배수 제외
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
