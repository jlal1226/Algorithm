package BaekJoon;

import java.io.*;
import java.util.StringTokenizer;

public class WordCount_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        System.out.println(st.countTokens());
    }
}
