package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM_Hotel_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int row;
        int col;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            if (n % h == 0) {
                col = n / h;
                sb.append((h*100) + col).append("\n");
            }else {
                row = n % h;
                col = n / h + 1;
                sb.append((row*100) + col).append("\n");
            }
        }
        System.out.println(sb);

    }
}
