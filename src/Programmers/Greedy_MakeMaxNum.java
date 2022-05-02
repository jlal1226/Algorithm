package Programmers;



import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Greedy_MakeMaxNum {
    public static void main(String[] args) {
        String num = "00001";
        int k = 1;
        String result = solution(num, k);
        System.out.println(result);
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int maxIndex = 0;
        int checkNum = number.length() - k;

        int tmp = 0;
        while (true) {
            if (checkNum == 0) {
                break;
            }
            int max = 0;
            for (int i = maxIndex; i <= number.length() - (checkNum); i++) {
                int check = number.charAt(i) - '0';
                if (number.charAt(i) - '0' > max) {
                    max = number.charAt(i) - '0';
                    tmp = i;
                }
            }
            answer.append(number.charAt(tmp));
            maxIndex = tmp + 1;
            checkNum--;
        }


        // 0제거


        return answer.toString();
    }
}
