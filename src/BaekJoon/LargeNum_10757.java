package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;


public class LargeNum_10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int max = Math.max(s1.length(), s1.length());

        int[] arr1 = new int[max + 1];
        int[] arr2 = new int[max + 1];

        for (int i = s1.length() - 1, index = 0; i >= 0; i--, index++) {
            arr1[index] = s1.charAt(i) - '0';
        }
        for (int i = s2.length() - 1, index = 0; i >= 0; i--, index++) {
            arr2[index] = s2.charAt(i) - '0';
        }

        for (int i = 0; i < max; i++) {
            int value = arr1[i] + arr2[i];
            arr1[i] = value % 10;
            arr1[i+1] += (value / 10);
        }

        StringBuilder sb = new StringBuilder();
        if (arr1[max] != 0)
            sb.append(arr1[max]);
        for (int i = max - 1; i >= 0; i--) {
            sb.append(arr1[i]);
        }
        System.out.println(sb);
    }
}
