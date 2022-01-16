package BaekJoon;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class NumSum_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
/*        for (int i = 0; i < num; i++){
            sum += input.charAt(i) - 48;
        }*/

        // getByte() : UTF-16으로 byte[] return -> 아스키코드와 호환 가능
        for (byte value : input.getBytes()) {
            sum += (value - '0');
        }
        System.out.println(sum);
    }
}
