package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class SangSu_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        String num1 = st.nextToken();
        String num2 = st.nextToken();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 2; i >= 0; i--) {
            sb1.append(num1.charAt(i));
            sb2.append(num2.charAt(i));
        }
        if (Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString())) {
            System.out.println(sb1);
        }else {
            System.out.println(sb2);
        }
    }
}
