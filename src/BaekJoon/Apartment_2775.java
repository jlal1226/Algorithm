package BaekJoon;

import java.io.*;

public class Apartment_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(func(k, n)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    // 함수를 이용한 방법
    public static int func(int k, int n) {
        int[] buff = new int[n];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for (int i = 1; i <= k; i++) {
            buff[0] = arr[0];
            for (int j = 1; j < n; j++) {
                buff[j] = arr[j] + buff[j-1];
            }
            for (int j = 0; j < n; j++) {
                arr[j] = buff[j];
            }
        }
        return buff[n-1];
    }
    // 2차원 배열을 활용한 방법
    public static void func2() {
        // 2차원 배열을 문제에 주어진 범위인 15 * 15만큼 생성하고
        // 2중 for문을 이용하여 배열을 채워 넣음
        // arr[k][n]만 출력하면 끝남
    }
}
