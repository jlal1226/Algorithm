package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 점화식 : f(n) = f(n-1) + f(n-2)
public class Tile01_1904 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[1000001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < arr.length; i++) {
            arr[i] = -1;
        }
        int result = tile(N);
        System.out.println(result);
    }
    static int tile(int N) {
        if (arr[N] == -1) {
            return arr[N] = (tile(N-1) + tile(N-2)) % 15749;
        }
        return arr[N];
    }
}
