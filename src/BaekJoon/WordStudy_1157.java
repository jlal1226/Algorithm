package BaekJoon;

import java.io.*;
import java.util.Locale;

public class WordStudy_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        String s = bf.readLine().toUpperCase();


        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 65]++;
        }
        int max = 0;
        boolean check = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
                check = false;
            }
            else if (arr[max] == arr[i])
                check = true;
        }
        if (check)
            System.out.println("?");
        else {
            char ch = (char)(max+65);
            System.out.println(ch);
        }
    }
}
