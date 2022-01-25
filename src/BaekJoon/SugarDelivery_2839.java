package BaekJoon;

import java.io.*;

public class SugarDelivery_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = -1;
        if (n == 4 || n == 7)
            result = -1;
        else if (n % 5  == 0)
            result = n / 5;
        else if (n % 5 == 1 || n % 5 == 3)
            result = n / 5 + 1;
        else if (n % 5 == 2 || n % 5 == 4)
            result = n / 5 + 2;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
