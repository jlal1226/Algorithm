package BaekJoon;

import java.io.*;

public class Dial_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'A';
            if (tmp < 3){
                cnt += 2;
            } else if (tmp < 6)
                cnt += 3;
            else if (tmp < 9)
                cnt += 4;
            else if (tmp < 12)
                cnt += 5;
            else if (tmp < 15)
                cnt += 6;
            else if (tmp < 19)
                cnt += 7;
            else if (tmp < 22)
                cnt += 8;
            else
                cnt += 9;

            cnt += 1;
        }
        System.out.println(cnt);
    }
}
