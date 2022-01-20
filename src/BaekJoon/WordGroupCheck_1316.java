package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class WordGroupCheck_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        int cnt = 0;
        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            boolean check = true;
            Arrays.fill(arr, 0);
            for (int j = 0; j < s.length(); j++) { // 알파벳 체크
                int index = s.charAt(j) - 'a';
                if (arr[index] == -1) {
                    check = false;
                    break;
                }
                if (j < s.length()-1 && s.charAt(j) == s.charAt(j+1))
                    arr[index] = 1;
                else
                    arr[index] = -1;
            }
            if (check)
                cnt++;
        }
        System.out.println(cnt);
    }
}
