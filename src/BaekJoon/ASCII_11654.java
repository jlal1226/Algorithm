package BaekJoon;

import java.io.*;

public class ASCII_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int c = input.charAt(0); // 문자의 아스키코드 값을 반환한다.

        bw.write(String.valueOf(c));
        bw.flush();
        bw.close();

    }
}
