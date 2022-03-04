package Programmers;

import java.util.*;

public class FindPrimeNum {
    static int[] arr;
    static int len;
    static boolean[] check;
    static List<Integer> primeList = new ArrayList<>();
    public static void main(String[] args) {
        //int result = solution("011");
        //System.out.println(result);
        getAllSet("", "011");
        System.out.println(getResult(set));
    }
    public static int solution(String numbers) {
        len = numbers.length();
        arr = new int[len];
        check = new boolean[len];
        for (int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        for (int i = 0; i < len; i++) {
            func(i, 0, arr[i]);
            check[i] = false;
        }
        return primeList.size();
    }

    static void func(int n, int cnt, int prev) {
        int number = prev;
        if (cnt != 0) {
            number = prev + arr[n] * (int) (Math.pow(10, cnt));
        }
        System.out.println(number);
        check[n] = true;
        if (isPrime(number) && !primeList.contains(number)){
            System.out.println(number);
            primeList.add(number);
        }
        System.out.println("visited : " + arr[n]);
        for (int i = 0; i < len; i++) {
            if(!check[i]) {
                cnt++;
                func(i, cnt, number);
                check[i] = false;
            }
        }
    }
    static HashSet<Integer> set = new HashSet<>();
    // HashSet을 이용한 풀이 -> 중복 허용 X, 입력 순서 X
    static void getAllSet(String prev, String str) {
        if (!prev.equals(""))
            set.add(Integer.valueOf(prev));
        for (int i = 0; i < str.length(); i++) {
            getAllSet(prev + str.charAt(i), str.substring(0,i) + str.substring(i+1, str.length()));
        }
    }

    static int getResult(HashSet<Integer> set) {
        int result = 0;
        System.out.println(set);
        Iterator<Integer> list = set.iterator();
        while (list.hasNext()) {
            int tmp = list.next();
            if (isPrime(tmp)) {
                System.out.println(tmp);
                result++;
            }
        }
        return result;
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n % 2 == 0)
            return n == 2;
        for(int i = 3; i*i <= n; i+=2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
