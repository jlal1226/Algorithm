package BaekJoon;

import java.io.*;

public class FindFraction_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int x; // 열
        int y; // 행
        int i = 1;

        while (true) {
            if (n <= i) {
                if (i % 2 == 0) { // 짝수
                    y = n;
                    x = i - n + 1;
                }else {
                    x = n;
                    y = i - n + 1;
                }
                break;
            }
            n -= i++;
        }
        bw.write(String.valueOf(y) + "/" + String.valueOf(x));
        bw.flush();
        bw.close();
    }
}
