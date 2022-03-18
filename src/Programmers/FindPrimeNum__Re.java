package Programmers;

import java.util.HashSet;

public class FindPrimeNum__Re {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        int result = solution("123");
    }
    public static int solution(String numbers) {
        int result = 0;
        getAllSet("", numbers);
        System.out.println(set);

        // set 윈소들을 소수 판정하고 결과 return

        return result;
    }
    // 재귀 활용 + Set 활용
    public static void getAllSet(String prev, String str) {
        if(!prev.equals("")) {
            set.add(Integer.parseInt(prev));
        }
        for (int i = 0; i < str.length(); i++) {
            getAllSet(prev + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
        }
    }

    // 소수 검증
    static boolean checkPrimeNum(String str) {
        int tmp = Integer.parseInt(str);
        System.out.println(tmp);
        for (int i = 3; i * i <= tmp; i += 2) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }
}
