package BaekJoon;

import java.util.Scanner;

public class Sequence_1065 {
    static int func(int n, int d) {
        if ((n/10) == 0){
            return d;
        }else{
            int tmp1 = n % 10;
            n /= 10;
            int tmp2 = tmp1 - (n % 10); // 공차 구하기
            int result = func(n, tmp2);

            if (result == tmp2){
                return result;
            }else
                return -999;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        int d = 1;
        int cnt = 0;
        for (int i = 1; i <= input; i++){
            if (func(i, d) != -999)
                cnt++;
        }
        System.out.println(cnt);
    }
}
