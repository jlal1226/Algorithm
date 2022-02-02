package BaekJoon;

import java.io.*;

public class Fibonacci_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(func(n)));
        bw.flush();
        bw.close();
    }

    public static int func(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return func(n-1) + func(n-2);
    }
}
